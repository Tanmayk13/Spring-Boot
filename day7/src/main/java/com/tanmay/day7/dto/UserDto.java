package com.tanmay.day7.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank(message = "Username is required!")
    private String userName;

    public String getUserName() {
        return userName;
    }
}
