package com.jwelzbacher.swisstournament.controller;

import com.jwelzbacher.swisstournament.models.Tournament;
import com.jwelzbacher.swisstournament.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class TournamentController {
    @Autowired
    TournamentService tournamentService;

    @PostMapping("/api/tournament")
    public ResponseEntity<?> createTournament (@RequestBody Tournament config) {
        return tournamentService.createTournament(config);
    }

    @GetMapping("/api/tournaments")
    public ResponseEntity<?> getTournaments () {
        return tournamentService.getTournaments();
    }

    @GetMapping("/api/tournament/{id}")
    public ResponseEntity<?> getTournaments (@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }
}