package com.tanmay.day4.controller;

import com.tanmay.day4.dto.TaskDto;
import com.tanmay.day4.entity.Task;
import com.tanmay.day4.service.TaskService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<@NonNull Task> createTask(@RequestBody TaskDto dto) {
        Task task = service.createTask(dto);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<@NonNull List<Task>> getTasks() {
        return ResponseEntity.ok(service.getTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<@NonNull Task> updateTask(@PathVariable Integer id, @RequestBody TaskDto dto) {
        Task task = service.updateTask(id, dto);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Void> deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull Task> getTaskById(@PathVariable Integer id) {
        Task task = service.getTaskById(id);
        return ResponseEntity.ok(task);
    }
}
