package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.models.Tournament;
import com.jwelzbacher.swisstournament.repositories.TournamentAtAGlanceRepository;
import com.jwelzbacher.swisstournament.repositories.TournamentRepository;
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

    public ResponseEntity<?> createTournament (Tournament config) {
        Tournament tournament = tournamentRepository.save(config);
        return new ResponseEntity<Object>(tournament, HttpStatus.OK);
    }

    public ResponseEntity<?> getTournaments (Long userId) {
        if (userId == null || userId == 0) {
            return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(tournamentAtAGlanceRepository.getTournamentsAtAGlance(userId), HttpStatus.OK);
    }

    public ResponseEntity<?> getTournamentById (Long id) {
        return new ResponseEntity<Object>(tournamentRepository.findById(id), HttpStatus.OK);
    }
}
