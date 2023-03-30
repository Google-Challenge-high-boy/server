package com.highboy.server.controller.friend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
public class FriendCreateResponseDto {

    private final int status;

    public FriendCreateResponseDto() {
        this.status=200;
    }
}
