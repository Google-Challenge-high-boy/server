package com.highboy.server.repository;

import com.highboy.server.domain.friend.Friend;
import com.highboy.server.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    Optional<Friend> findByFolloweeAndFollower(User followee, User follower);

    @Query(value = "select distinct f from Friend f left join fetch f.followee where f.follower.id = :followerId")
    List<Friend> findAllFriendsByFollower(@Param("followerId") Long followerId);

}
