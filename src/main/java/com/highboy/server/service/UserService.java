package com.highboy.server.service;

import com.highboy.server.domain.user.User;
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

    public Boolean insertUser(User user) {
        if(isEmailDuplicated(user.getEmail()))
        {
            userRepository.save(user);
            return true;
        }
        else return false;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
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