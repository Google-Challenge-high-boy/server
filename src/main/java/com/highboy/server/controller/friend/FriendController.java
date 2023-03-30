package com.highboy.server.controller.friend;

import com.highboy.server.controller.friend.dto.FriendCreateRequestDto;
import com.highboy.server.controller.friend.dto.FriendCreateResponseDto;
import com.highboy.server.controller.friend.dto.FriendFollowersResponseDto;
import com.highboy.server.controller.user.dto.UserInfoDto;
import com.highboy.server.domain.friend.Friend;
import com.highboy.server.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/v1/friends")
@RestController
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @GetMapping("")
    public FriendFollowersResponseDto getFriends(HttpServletRequest request){
        int userId = Integer.parseInt(request.getHeader("userId"));
        List<Friend> friendList = friendService.getFriends((long) userId);
        return new FriendFollowersResponseDto(friendList);
    }

    @PostMapping("")
    public FriendCreateResponseDto createFriend(HttpServletRequest request, @Valid @RequestBody FriendCreateRequestDto friendCreateRequestDto){
        int userId = Integer.parseInt(request.getHeader("userId"));
        friendService.startFollowing((long) userId,friendCreateRequestDto.getFriendId());
        return new FriendCreateResponseDto();
    }
}
