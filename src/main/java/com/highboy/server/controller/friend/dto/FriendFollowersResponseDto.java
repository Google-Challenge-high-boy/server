package com.highboy.server.controller.friend.dto;

import com.highboy.server.domain.friend.Friend;
import lombok.Getter;

import java.util.List;

@Getter
public class FriendFollowersResponseDto {

    private final int status;
    private  final List<Friend> friendList;

    public FriendFollowersResponseDto(List<Friend> friendList) {
        this.status=200;
        this.friendList = friendList;
    }
}