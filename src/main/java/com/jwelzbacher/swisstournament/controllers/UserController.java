package com.jwelzbacher.swisstournament.controllers;

import com.jwelzbacher.swisstournament.models.User;
import com.jwelzbacher.swisstournament.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/user/login")
    public ResponseEntity<?> validateUser(@RequestBody User user) {
        return userService.validateUser(user);
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/api/protected/user/me")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        return userService.validateToken(authHeader);
    }

}
