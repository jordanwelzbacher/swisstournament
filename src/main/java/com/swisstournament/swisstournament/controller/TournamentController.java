package com.swisstournament.swisstournament.controller;

import com.swisstournament.swisstournament.models.TournamentConfig;
import com.swisstournament.swisstournament.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tournament")

public class TournamentController {
    @Autowired
    TournamentService tournamentService;

    @PostMapping()
    public ResponseEntity createTournament (@RequestBody TournamentConfig config) {
        ResponseEntity response = tournamentService.createTournament(config);
        return response;
    }
}