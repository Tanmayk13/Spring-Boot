package com.tanmay.day8.dto;

import java.util.List;

public class UserResponseDto {
    private final Integer id;
    private final String userName;
    private final List<TaskResponseDto> tasks;
    private final String password;
    private final String role;

    public UserResponseDto(Integer id, String userName, List<TaskResponseDto> tasks, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.tasks = tasks;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public List<TaskResponseDto> getTasks() {
        return tasks;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
