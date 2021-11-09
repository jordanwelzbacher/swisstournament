package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.exceptions.UnauthorizedException;
import com.jwelzbacher.swisstournament.services.AdminService;
import com.jwelzbacher.swisstournament.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    TournamentService tournamentService;

    @GetMapping("/api/admins/{tournamentId}")
    public ResponseEntity<?> get(@PathVariable Long tournamentId) {
        return new ResponseEntity<>(adminService.getAdminsByTournamentId(tournamentId), HttpStatus.OK);
    }

    @DeleteMapping("/api/protected/admins/{tournamentId}/{adminId}")
    public ResponseEntity<?> delete(@PathVariable Long tournamentId, @PathVariable Long adminId, HttpServletRequest request) {
        if (
            adminService.isAdmin(tournamentId, Long.parseLong(request.getAttribute("id").toString()))
            || tournamentService.isOwner(tournamentId, Long.parseLong(request.getAttribute("id").toString()))
        ) {
            adminService.deleteByAdminId(adminId);
        }
        else {
            throw new UnauthorizedException("Unauthorized");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
