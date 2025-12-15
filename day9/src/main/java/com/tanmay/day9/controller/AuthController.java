package com.tanmay.day9.controller;

import com.tanmay.day9.dto.JWTResponse;
import com.tanmay.day9.dto.LoginRequest;
import com.tanmay.day9.dto.SignupRequest;
import com.tanmay.day9.service.AuthService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<@NonNull String> signUp(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/login")
    public ResponseEntity<@NonNull JWTResponse> login(@RequestBody LoginRequest request) {
        JWTResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
