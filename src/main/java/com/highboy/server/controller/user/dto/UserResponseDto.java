package com.highboy.server.controller.user.dto;


import com.highboy.server.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long userId;
    private final String name;
    private final String email;

    public UserResponseDto(User entity) {
        this.userId = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}