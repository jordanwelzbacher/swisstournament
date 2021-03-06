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
    AdminWithUsernameRepository adminWithUsernameRepository;
    @Autowired
    PlayerRepository playerRepository;

    public ResponseEntity<?> createTournament (Tournament config) {
        Tournament tournament = tournamentRepository.save(config);
        return new ResponseEntity<Object>(tournament, HttpStatus.OK);
    }

    public ResponseEntity<?> getTournaments (Long userId) {
        return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(), HttpStatus.OK);
//        if (userId == null || userId == 0)
//            return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(), HttpStatus.OK);
//        else {
//            ResponseEntity<Object> o = new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(userId), HttpStatus.OK);
//            System.out.println(o.getBody());
//            return o;
//        }
    }

    public ResponseEntity<?> getTournamentById (Long id) {
        TournamentInFull tournamentInFull = new TournamentInFull();
        tournamentInFull.setTournament(tournamentAtAGlanceRepository.findByTournamentId(id));
        tournamentInFull.setAdmins(adminWithUsernameRepository.findByTournamentId(id));
        tournamentInFull.setPlayers(playerRepository.findByTournamentId(id));
        return new ResponseEntity<Object>(tournamentInFull, HttpStatus.OK);
    }

    public boolean isOwner (Long tournamentId, Long ownerId) {
        return tournamentRepository.getById(tournamentId).getOwnerUserId().equals(ownerId);
    }

    public boolean isOwnerByPairingId(Long pairingId, Long ownerId) {
        return isOwner(tournamentRepository.getIdByPairingId(pairingId), ownerId);
    }
}
