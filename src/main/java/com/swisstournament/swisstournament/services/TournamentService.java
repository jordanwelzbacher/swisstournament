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
    TournamentConfigRepository tournamentRepository;

    public ResponseEntity createTournament (TournamentConfig config) {
        TournamentConfig otherConfig = tournamentRepository.save(config);
        return new ResponseEntity(otherConfig, HttpStatus.OK);
    }
}
