package com.tanmay.day10.controller;

import com.tanmay.day10.dto.TaskDto;
import com.tanmay.day10.dto.TaskResponseDto;
import com.tanmay.day10.service.TaskService;
import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
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
    public ResponseEntity<@NonNull Page<@NonNull TaskResponseDto>> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(service.getTasks(page, size));
    }

    @GetMapping("/completed")
    public ResponseEntity<@NonNull Page<@NonNull TaskResponseDto>> getCompletedTasks(
            @RequestParam(defaultValue = "false") boolean completed,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(service.getCompletedTasks(completed, page, size));
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
