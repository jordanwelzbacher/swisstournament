package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.exceptions.UnauthorizedException;
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
    public ResponseEntity<?> createTournament (@RequestBody Tournament config, HttpServletRequest request) throws UnauthorizedException {
        if (request.getAttribute("username") == null)
            throw new UnauthorizedException("You must login to submit a tournament");
        return tournamentService.createTournament(config);
    }

    @GetMapping(value={"/api/tournaments/{username}", "/api/tournaments"})
    public ResponseEntity<?> getTournaments (@PathVariable(required = false) String username) {
        System.out.println("here " + username);
        return tournamentService.getTournaments();
    }

    @GetMapping("/api/tournament/{id}")
    public ResponseEntity<?> getTournaments (@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }
}