package com.tanmay.day9.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskDto {
    @NotBlank
    private String name;
    @Size(max = 200)
    private String description;
    @NotNull
    private Boolean completed;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isCompleted() {
        return completed;
    }
}
