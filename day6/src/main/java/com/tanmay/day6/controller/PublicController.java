package com.tanmay.day6.controller;

import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/hello")
    public ResponseEntity<@NonNull String> hello() {
        return ResponseEntity.ok("Hello there!");
    }
}
