package com.tanmay.day4.service;

import com.tanmay.day4.dto.TaskDto;
import com.tanmay.day4.entity.Task;
import com.tanmay.day4.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getTasks() {
        return repo.findAll();
    }

    public Task createTask(TaskDto dto) {
        Task task = mapToEntity(dto);
        return repo.save(task);
    }

    public void deleteTask(Integer id) {
        repo.deleteById(id);
    }

    public Task updateTask(Integer id, TaskDto dto) {
        Task existingTask = repo.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );

        existingTask.setName(dto.getName());
        existingTask.setDescription(dto.getDescription());
        existingTask.setCompleted(dto.isCompleted());

        return repo.save(existingTask);
    }

    public Task getTaskById(Integer id) {
        return repo.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
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
