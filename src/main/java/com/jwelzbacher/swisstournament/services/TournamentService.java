package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.DTOs.TournamentInFull;
import com.jwelzbacher.swisstournament.models.*;
import com.jwelzbacher.swisstournament.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    TournamentAtAGlanceRepository tournamentAtAGlanceRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RoundRepository roundRepository;
    @Autowired
    PairingRepository pairingRepository;
    @Autowired
    PlayerService playerService;

    public ResponseEntity<?> createTournament (Tournament config) {
        System.out.println(config.isLowerBetterForFirstCustom());
        System.out.println(config.isLowerBetterForSecondCustom());
        Tournament tournament = tournamentRepository.save(config);
        return new ResponseEntity<Object>(tournament, HttpStatus.OK);
    }

    public ResponseEntity<?> getTournaments (Long userId) {
        if (userId == null || userId == 0) {
            return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(), HttpStatus.OK);
        }
        else return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(userId), HttpStatus.OK);
    }

    public ResponseEntity<?> getTournamentById (Long id) {
        TournamentInFull tournamentInFull = new TournamentInFull();
        tournamentInFull.setTournament(tournamentRepository.findById(id).get());
        tournamentInFull.setAdmins(adminRepository.findByTournamentIdd(id));
        tournamentInFull.setRounds(roundRepository.findByTournamentIdOrderByRoundNumber(id));
        tournamentInFull.setPlayers(playerService.getPlayersByTournamentId(id));
        int i = 0;
        for (Round round : tournamentInFull.getRounds()) {
            tournamentInFull.addPairingsOfRound(++i, pairingRepository.findByRoundId(round.getId()));
        }
        return new ResponseEntity<Object>(tournamentInFull, HttpStatus.OK);
    }
}
