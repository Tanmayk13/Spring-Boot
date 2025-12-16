package com.tanmay.day10.dto;

public class TaskResponseDto {
    private final Integer id;
    private final String name;
    private final String description;
    private final Boolean completed;
    private final Integer userId;

    public TaskResponseDto(Integer id, String name, String description, Boolean completed, Integer userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Integer getUserId() {
        return userId;
    }
}
