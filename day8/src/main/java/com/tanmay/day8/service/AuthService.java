package com.tanmay.day8.service;

import com.tanmay.day8.dto.SignupRequest;
import com.tanmay.day8.entity.User;
import com.tanmay.day8.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository repo) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
    }

    public String signUp(SignupRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        repo.save(user);
        return "User Created";
    }
}
