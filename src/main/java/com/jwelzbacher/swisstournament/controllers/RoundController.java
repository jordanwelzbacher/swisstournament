package com.jwelzbacher.swisstournament.controllers;


import com.jwelzbacher.swisstournament.services.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoundController {

    @Autowired
    RoundService roundService;

    @GetMapping("/api/rounds/{tournamentId}")
    public ResponseEntity<?> get(@PathVariable Long tournamentId) {
        return new ResponseEntity<>(roundService.getRoundsByTournamentId(tournamentId), HttpStatus.OK);
    }
}
