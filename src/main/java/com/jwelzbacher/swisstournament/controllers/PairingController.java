package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.exceptions.UnauthorizedException;
import com.jwelzbacher.swisstournament.models.Pairing;
import com.jwelzbacher.swisstournament.services.AdminService;
import com.jwelzbacher.swisstournament.services.PairingService;
import com.jwelzbacher.swisstournament.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @PutMapping("api/protected/pairing/{pairingId}")
    public ResponseEntity<?> putById(@PathVariable Long pairingId, @RequestBody Pairing results, HttpServletRequest request) {
            pairingService.updateById(pairingId, results, Long.parseLong(request.getAttribute("id").toString()));
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
