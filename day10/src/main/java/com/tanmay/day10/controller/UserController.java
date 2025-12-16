package com.tanmay.day10.controller;

import com.tanmay.day10.dto.*;
import com.tanmay.day10.service.AuthService;
import com.tanmay.day10.service.UserService;
import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final AuthService authService;

    UserController(UserService service, AuthService authService) {
        this.service = service;
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<@NonNull UserResponseDto> createUser(@RequestBody @Valid UserDto userDto) {
        UserResponseDto userResponseDto = service.createUser(userDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull UserResponseDto> getUser(@PathVariable Integer id) {
        UserResponseDto userResponseDto = service.getUserById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<@NonNull TaskResponseDto> assignTaskToUser(@PathVariable Integer id, @RequestBody @Valid TaskDto dto) {
        TaskResponseDto assignedTaskResponseDto = service.assignTaskToUser(id, dto);
        return ResponseEntity.ok(assignedTaskResponseDto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = service.getAllUsersWithTasks();

        // Access tasks to trigger LAZY loading
        userResponseDtos.forEach(u -> System.out.println(u.getTasks().size()));

        return userResponseDtos;
    }
}
