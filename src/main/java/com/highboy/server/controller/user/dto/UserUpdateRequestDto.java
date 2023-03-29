package com.highboy.server.controller.user.dto;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserUpdateRequestDto {
    @NotNull(message = "이름이 필요합니다.")
    private final String name;

    @Builder
    public UserUpdateRequestDto(@NonNull String name
    ) {
        this.name = name;
    }

}