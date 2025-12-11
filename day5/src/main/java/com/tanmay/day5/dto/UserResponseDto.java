package com.tanmay.day5.dto;

import java.util.List;

public class UserResponseDto {
    private final Integer id;
    private final String userName;
    private final List<TaskResponseDto> tasks;

    public UserResponseDto(Integer id, String userName, List<TaskResponseDto> tasks) {
        this.id = id;
        this.userName = userName;
        this.tasks = tasks;
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
}
