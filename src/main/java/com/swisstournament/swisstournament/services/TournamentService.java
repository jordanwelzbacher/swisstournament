package com.swisstournament.swisstournament.services;

import com.swisstournament.swisstournament.models.Tournament;
import com.swisstournament.swisstournament.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;

    public ResponseEntity<?> createTournament (Tournament config) {
        Tournament newTournament = tournamentRepository.save(config);
        return new ResponseEntity<Object>(newTournament, HttpStatus.OK);
    }

    public ResponseEntity<?> getTournaments () {
        return new ResponseEntity<Object>(tournamentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getTournamentById (Long id) {
        return new ResponseEntity<Object>(tournamentRepository.findById(id), HttpStatus.OK);
    }
}
