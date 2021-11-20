package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.exceptions.ForbiddenException;
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

    @PostMapping("api/protected/admins/{tournamentId}")
    public ResponseEntity<?> add(@PathVariable Long tournamentId, @RequestParam(name = "username") String username, HttpServletRequest request) {
        //only admins or the owner can add admin
        if (
            adminService.isAdminByTournamentId(tournamentId, Long.parseLong(request.getAttribute("id").toString()))
            || tournamentService.isOwner(tournamentId, Long.parseLong(request.getAttribute("id").toString()))
        ) {
            return new ResponseEntity<>(adminService.addAdmin(tournamentId, username), HttpStatus.OK);
        } else {
            throw new ForbiddenException("Forbidden");
        }
    }

    @DeleteMapping("/api/protected/admins/{adminId}")
    public ResponseEntity<?> delete(@PathVariable Long adminId, HttpServletRequest request) {
        //only admins or the owner can delete admin
        Long tournamentId = adminService.getByAdminId(adminId).getTournamentId();
        if (
            adminService.isAdminByTournamentId(tournamentId, Long.parseLong(request.getAttribute("id").toString()))
            || tournamentService.isOwner(tournamentId, Long.parseLong(request.getAttribute("id").toString()))
        ) {
            adminService.deleteByAdminId(adminId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ForbiddenException("Forbidden");
        }
    }
}
