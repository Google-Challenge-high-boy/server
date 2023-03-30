package com.highboy.server.controller.friend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
@Getter
@NoArgsConstructor
public class FriendCreateRequestDto {

    @NotNull(message = "친구 id가 필요합니다.")
    private Long friendId;

    @Builder
    public FriendCreateRequestDto(@NonNull Long friendId) {
        this.friendId = friendId;
    }
}
