package com.highboy.server.service;

import com.highboy.server.controller.user.dto.UserInfoDto;
import com.highboy.server.domain.friend.Friend;
import com.highboy.server.domain.user.User;
import com.highboy.server.exception.RecordNotFoundException;
import com.highboy.server.repository.FriendRepository;
import com.highboy.server.repository.UserRepository;
import com.highboy.server.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendService {
    private final UserRepository userRepository;

    private final FriendRepository friendRepository;

    @Transactional
    public Friend startFollowing(Long userId, Long friendId) {
        User user = checkUserRecord(userId);
        User target = checkUserRecord(friendId);
        Boolean result =  friendRepository.findByFolloweeAndFollower(user,target).isPresent();
        if(result) throw new ErrorResponse(400,"이미 친구입니다.");
        return  friendRepository.save(new Friend(target, user));
    }
    @Transactional
    public List<Friend> getFriends(Long userId) {
        User user = checkUserRecord(userId);
        return  friendRepository
                .findAllFriendsByFollower(user.getId());
    }


    private User checkUserRecord(Long userId) {
        return checkRecord(
                userRepository.findById(userId),
                "해당 ID의 User가 존재하지 않습니다."
        );
    }

    private Friend checkFriendRecord(User user, User target) {
        return checkRecord(
                friendRepository.findByFolloweeAndFollower(user,target),
                "해당 친구가 존재하지 않습니다."
        );
    }

    private <T> T checkRecord(Optional<T> record, String message) {
        return record.orElseThrow(() ->
                new RecordNotFoundException(message));
    }
}
