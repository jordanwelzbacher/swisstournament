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
    PlayerRepository playerRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RoundRepository roundRepository;
    @Autowired
    PairingRepository pairingRepository;

    public ResponseEntity<?> createTournament (Tournament config) {
        Tournament tournament = tournamentRepository.save(config);
        return new ResponseEntity<Object>(tournament, HttpStatus.OK);
    }

    public ResponseEntity<?> getTournaments (Long userId) {
        System.out.println(userId);
        if (userId == null || userId == 0) {
            return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(), HttpStatus.OK);
        }
        else return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(userId), HttpStatus.OK);
    }

    public ResponseEntity<?> getTournamentById (Long id) {
        TournamentInFull tournamentInFull = new TournamentInFull();
        tournamentInFull.setTournament(tournamentRepository.findById(id).get());
        tournamentInFull.setAdmins(adminRepository.findByTournamentId(id));
        tournamentInFull.setPlayers(playerRepository.findByTournamentId(id));
        tournamentInFull.setRounds(roundRepository.findByTournamentId(id));
        System.out.println(tournamentInFull.getRounds().size());
        for (Round round : tournamentInFull.getRounds()) {
            System.out.println("here");
            round.setPairings(pairingRepository.findByRoundId(round.getId()));
            for (Pairing pairing : round.getPairings()) {
                System.out.println(pairing.getPlayerAId() + " vs " + pairing.getPlayerBId());
            }
        }

        return new ResponseEntity<Object>(tournamentInFull, HttpStatus.OK);
    }
}
