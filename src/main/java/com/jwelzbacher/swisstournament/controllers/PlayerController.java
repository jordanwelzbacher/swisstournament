package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/api/players/{tournamentId}")
    public ResponseEntity<?> getPlayerScores(@PathVariable Long tournamentId) {
        return new ResponseEntity<>(playerService.getPlayersByTournamentId(tournamentId), HttpStatus.OK);
    }

    @GetMapping("/api/playernames/{tournamentId}")
    public ResponseEntity<?> getPlayers(@PathVariable Long tournamentId) {
        return new ResponseEntity<>(playerService.getPlayerNamesByTournamentId(tournamentId), HttpStatus.OK);
    }

}
