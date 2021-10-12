package com.jwelzbacher.swisstournament.controller;

import com.jwelzbacher.swisstournament.exceptions.EtAuthException;
import com.jwelzbacher.swisstournament.models.Tournament;
import com.jwelzbacher.swisstournament.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TournamentController {
    @Autowired
    TournamentService tournamentService;

    @PostMapping("/api/protected/tournament")
    public ResponseEntity<?> createTournament (@RequestBody Tournament config, HttpServletRequest request) {
        if (request.getAttribute("username") == null) throw new EtAuthException("You must login to submit a tournament");
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