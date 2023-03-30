package com.highboy.server.controller.user.dto;

import com.highboy.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {
    @NotNull(message = "이름이 필요합니다.")
    private String nickname;

    @NotNull(message = "이메일이 필요합니다.")
    private String email;

    @Builder
    public UserCreateRequestDto(@NonNull String nickname, @NonNull String email) {
        this.nickname = nickname;
        this.email = email;

    }

    public User toEntity() {
        return User.builder()
                .name(this.nickname)
                .email(this.email)
                .build();
    }
}