package com.highboy.server.controller.user.dto;


import com.highboy.server.domain.user.User;
import lombok.Getter;

import java.util.Optional;

@Getter
public class UserSimpleResponseDto {

    private final Number status;

    public UserSimpleResponseDto() {
        this.status = 200;
    }
}