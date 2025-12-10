package com.tanmay.day4.service;

import com.tanmay.day4.dto.TaskDto;
import com.tanmay.day4.dto.UserDto;
import com.tanmay.day4.entity.Task;
import com.tanmay.day4.entity.User;
import com.tanmay.day4.repository.TaskRepository;
import com.tanmay.day4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final TaskRepository taskRepo;

    UserService(UserRepository userRepo, TaskRepository taskRepo) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
    }

    public User createUser(UserDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        return userRepo.save(user);
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).orElseThrow(
                () -> new RuntimeException("User not found!")
        );
    }

    public Task assignTaskToUser(Integer id, TaskDto dto) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new RuntimeException("User not found!")
        );

        Task newTask = mapToTask(dto, user);
        return taskRepo.save(newTask);
    }

    private Task mapToTask(TaskDto dto, User user) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        task.setUser(user);
        return task;
    }
}
