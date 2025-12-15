package com.tanmay.day9.service;

import com.tanmay.day9.config.JWTUtils;
import com.tanmay.day9.dto.JWTResponse;
import com.tanmay.day9.dto.LoginRequest;
import com.tanmay.day9.dto.SignupRequest;
import com.tanmay.day9.entity.User;
import com.tanmay.day9.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository repo, AuthenticationManager authenticationManager, JWTUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public String signUp(SignupRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        repo.save(user);
        return "User Created";
    }

    public JWTResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        String token = jwtUtils.generateToken(request.getUserName());

        return new JWTResponse(token);
    }
}
