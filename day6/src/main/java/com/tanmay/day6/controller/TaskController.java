package com.tanmay.day6.controller;

import com.tanmay.day6.dto.TaskDto;
import com.tanmay.day6.dto.TaskResponseDto;
import com.tanmay.day6.service.TaskService;
import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController             {
    private final TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<@NonNull TaskResponseDto> createTask(@RequestBody @Valid TaskDto dto) {
        TaskResponseDto taskResponseDto = service.createTask(dto);
        return ResponseEntity.ok(taskResponseDto);
    }

    @GetMapping
    public ResponseEntity<@NonNull List<TaskResponseDto>> getTasks() {
        return ResponseEntity.ok(service.getTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<@NonNull TaskResponseDto> updateTask(@PathVariable Integer id, @RequestBody @Valid TaskDto dto) {
        TaskResponseDto taskResponseDto = service.updateTask(id, dto);
        return ResponseEntity.ok(taskResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Void> deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull TaskResponseDto> getTaskById(@PathVariable Integer id) {
        TaskResponseDto taskResponseDto = service.getTaskById(id);
        return ResponseEntity.ok(taskResponseDto);
    }
}
