package com.jwelzbacher.swisstournament.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")

public class MessageController {
    @GetMapping("/hello")
    public String hello() {
        return "Home page!";
    }
}