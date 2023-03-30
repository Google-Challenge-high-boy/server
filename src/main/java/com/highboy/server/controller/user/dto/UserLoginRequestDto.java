package com.highboy.server.controller.user.dto;

import com.highboy.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserLoginRequestDto {

    @NotNull(message = "이메일이 필요합니다.")
    private String email;

    @Builder
    public UserLoginRequestDto(@NonNull String email) {
        this.email = email;

    }
}