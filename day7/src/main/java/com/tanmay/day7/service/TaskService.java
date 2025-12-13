package com.tanmay.day7.service;

import com.tanmay.day7.dto.TaskDto;
import com.tanmay.day7.dto.TaskResponseDto;
import com.tanmay.day7.entity.Task;
import com.tanmay.day7.exception.TaskNotFoundException;
import com.tanmay.day7.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskResponseDto> getTasks() {
        return repo.findAll()
                .stream()
                .map(task -> new TaskResponseDto(
                        task.getId(),
                        task.getName(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getUser() != null ? task.getUser().getId() : null
                ))
                .toList();
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
