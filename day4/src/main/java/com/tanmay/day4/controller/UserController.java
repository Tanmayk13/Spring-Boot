package com.tanmay.day4.controller;

import com.tanmay.day4.dto.TaskDto;
import com.tanmay.day4.dto.UserDto;
import com.tanmay.day4.entity.Task;
import com.tanmay.day4.entity.User;
import com.tanmay.day4.service.UserService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<@NonNull User> createUser(@RequestBody UserDto userDto) {
        User user = service.createUser(userDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull User> getUser(@PathVariable Integer id) {
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<@NonNull Task> assignTaskToUser(@PathVariable Integer id, @RequestBody TaskDto dto) {
        Task assignedTask = service.assignTaskToUser(id, dto);
        return ResponseEntity.ok(assignedTask);
    }
}
