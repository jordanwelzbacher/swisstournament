package com.swisstournament.swisstournament.services;

import com.swisstournament.swisstournament.models.TournamentConfig;
import com.swisstournament.swisstournament.repositories.TournamentConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    @Autowired
    TournamentConfigRepository tournamentConfigRepository;

    public ResponseEntity createTournament (TournamentConfig config) {
        TournamentConfig newTournament = tournamentConfigRepository.save(config);
        return new ResponseEntity(newTournament, HttpStatus.OK);
    }

    public ResponseEntity getTournaments () {
        return new ResponseEntity(tournamentConfigRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity getTournamentById (Long id) {
        return new ResponseEntity(tournamentConfigRepository.getById(id), HttpStatus.OK);
    }
}
