package com.highboy.server.service;

import com.highboy.server.domain.user.User;
import com.highboy.server.exception.RecordNotFoundException;
import com.highboy.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Boolean isEmailDuplicated(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isEmpty();
    }


}