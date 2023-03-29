package com.highboy.server.controller.user.dto;

import com.highboy.server.domain.user.User;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserInfoDto {
    private final Long userId;
    private final String userName;
    private final String email;

    public UserInfoDto(User entity) {
        this.userId = entity.getId();
        this.userName = entity.getName();
        this.email = entity.getEmail();
    }
}