package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.services.PairingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PairingController {

    @Autowired
    PairingService pairingService;

    @GetMapping("/api/pairings/{roundId}")
    public ResponseEntity<?> get(@PathVariable Long roundId) {
        return new ResponseEntity<>(pairingService.getPairingsByRoundId(roundId), HttpStatus.OK);
    }

    @GetMapping("api/pairing/{pairingId}")
    public ResponseEntity<?> getById(@PathVariable Long pairingId) {
        return new ResponseEntity<>(pairingService.getById(pairingId), HttpStatus.OK);
    }
}
