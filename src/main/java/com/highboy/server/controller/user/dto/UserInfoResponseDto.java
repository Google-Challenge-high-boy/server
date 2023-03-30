package com.highboy.server.controller.user.dto;


import com.highboy.server.domain.user.User;
import lombok.Getter;

import java.util.Optional;

@Getter
public class UserInfoResponseDto {

    private final String userName;

    public UserInfoResponseDto(Optional<User> entity) {
        this.userName = entity.get().getName();
    }
}