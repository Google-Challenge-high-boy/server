package com.highboy.server.repository;

import com.highboy.server.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select m from Member m where m.accountName = :accountName")
    User findByUserName(String userName);
    Optional<User> findByEmail(String email);

    Page<User> findAll(Pageable pageable);
}