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
    private String name;

    @NotNull(message = "이메일이 필요합니다.")
    private String email;

    private String password;

    @NotNull(message = "전화번호가 필요합니다.")
    private String phoneNumber;

    //    @NotNull(message = "구글 아이디가 필요합니다.")
    private Long googleId;

    @Builder
    public UserCreateRequestDto(@NonNull String name,
                                @NonNull String email,
                                Long googleId,
                                String password) {
        this.name = name;
        this.email = email;
        this.googleId = googleId;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .googleId(this.googleId)
                .build();
    }
}