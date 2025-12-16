package com.tanmay.day10.service;

import com.tanmay.day10.dto.TaskDto;
import com.tanmay.day10.dto.TaskResponseDto;
import com.tanmay.day10.entity.Task;
import com.tanmay.day10.exception.TaskNotFoundException;
import com.tanmay.day10.repository.TaskRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Page<@NonNull TaskResponseDto> getTasks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").descending());

        return repo.findAll(pageable)
                .map(task -> new TaskResponseDto(
                        task.getId(),
                        task.getName(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getUser() != null ? task.getUser().getId() : null
                ));
    }

    public Page<@NonNull TaskResponseDto> getCompletedTasks(boolean completed, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<@NonNull Task> taskPage = repo.findByCompleted(completed, pageable);

        return taskPage.map(task -> new TaskResponseDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.isCompleted(),
                task.getUser() != null ? task.getUser().getId() : null
        ));
    }


    public TaskResponseDto createTask(TaskDto dto) {
        Task task = mapToEntity(dto);
        Task savedTask = repo.save(task);

        return new TaskResponseDto(
                savedTask.getId(),
                savedTask.getName(),
                savedTask.getDescription(),
                savedTask.isCompleted(),
                savedTask.getUser() != null ? savedTask.getUser().getId() : null
        );
    }

    public void deleteTask(Integer id) {
        if (!repo.existsById(id)) {
            throw new TaskNotFoundException("Task not found");
        }
        repo.deleteById(id);
    }

    public TaskResponseDto updateTask(Integer id, TaskDto dto) {
        Task existingTask = repo.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found")
        );

        existingTask.setName(dto.getName());
        existingTask.setDescription(dto.getDescription());
        existingTask.setCompleted(dto.isCompleted());

        Task savedTask = repo.save(existingTask);

        return new TaskResponseDto(
                savedTask.getId(),
                savedTask.getName(),
                savedTask.getDescription(),
                savedTask.isCompleted(),
                savedTask.getUser() != null ? savedTask.getUser().getId() : null
        );
    }

    public TaskResponseDto getTaskById(Integer id) {
        Task task = repo.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found")
        );

        return new TaskResponseDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.isCompleted(),
                task.getUser() != null ? task.getUser().getId() : null
        );
    }

    private Task mapToEntity(TaskDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return task;
    }
}
