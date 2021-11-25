package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.exceptions.BadRequestException;
import com.jwelzbacher.swisstournament.exceptions.UnauthorizedException;
import com.jwelzbacher.swisstournament.models.Pairing;
import com.jwelzbacher.swisstournament.repositories.PairingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PairingService {

    @Autowired
    PairingRepository pairingRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    TournamentService tournamentService;

    public List<Pairing> getPairingsByRoundId(Long roundId) {
        return pairingRepository.findByRoundId(roundId);
    }

    public Pairing getById(Long pairingId) {
        try {
            return pairingRepository.findById(pairingId).get();
        }
        catch (Exception e) {
            throw new BadRequestException("Invalid pairing Id");
        }
    }

    public void updateById(Long pairingId, Pairing results, Long userId) {
        System.out.println(pairingId +" "+ userId);
        if (adminService.isAdminByPairingId(pairingId, userId)
                || tournamentService.isOwnerByPairingId(pairingId, userId)) {
            updateResults(pairingId, results);
        } else {
            Pairing pairing = pairingRepository.findById(pairingId).get();
            if (pairing.getMatchResultFirstPlayer().isBlank()) {
                updateResults(pairingId, results);
            }
            else throw new UnauthorizedException("Results already submitted");
        }
    }

    private void updateResults(Long pairingId, Pairing results) {
        if (! (results.getMatchResultFirstPlayer().equals("WIN") ||
                results.getMatchResultFirstPlayer().equals("LOSS") ||
                results.getMatchResultFirstPlayer().equals("DRAW"))
        ) throw new BadRequestException("Bad Request");
        if (! (results.getMatchResultSecondPlayer().equals("WIN") ||
                results.getMatchResultSecondPlayer().equals("LOSS") ||
                results.getMatchResultSecondPlayer().equals("DRAW"))
        ) throw new BadRequestException("Bad Request");

        Pairing pairing = pairingRepository.findById(pairingId).get();
        pairing.setMatchResultFirstPlayer(results.getMatchResultFirstPlayer());
        pairing.setMatchResultSecondPlayer(results.getMatchResultSecondPlayer());
        pairing.setGameWinsFirstPlayer(results.getGameWinsFirstPlayer());
        pairing.setGameWinsSecondPlayer(results.getGameWinsSecondPlayer());
        pairing.setGameDrawsFirstPlayer(results.getGameDrawsFirstPlayer());
        pairing.setGameDrawsSecondPlayer(results.getGameDrawsSecondPlayer());
        pairing.setGameLossesFirstPlayer(results.getGameLossesFirstPlayer());
        pairing.setGameLossesSecondPlayer(results.getGameLossesSecondPlayer());
        pairing.setFirstCustomFirstPlayer(results.getFirstCustomFirstPlayer());
        pairing.setFirstCustomSecondPlayer(results.getFirstCustomSecondPlayer());
        pairing.setSecondCustomFirstPlayer(results.getSecondCustomFirstPlayer());
        pairing.setSecondCustomSecondPlayer(results.getSecondCustomSecondPlayer());
        pairingRepository.save(pairing);
    }
}
