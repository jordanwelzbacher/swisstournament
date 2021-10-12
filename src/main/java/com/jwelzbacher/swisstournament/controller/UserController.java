package com.jwelzbacher.swisstournament.controller;

import com.jwelzbacher.swisstournament.Constants;
import com.jwelzbacher.swisstournament.models.User;
import com.jwelzbacher.swisstournament.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/users/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return userService.validateUser(user);
    }

    @PostMapping("/api/users/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }


}
