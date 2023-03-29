package com.highboy.server.controller.user;

import com.highboy.server.controller.user.dto.UserCreateRequestDto;
import com.highboy.server.controller.user.dto.UserResponseDto;
import com.highboy.server.domain.user.User;
import com.highboy.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/signup")
    public UserResponseDto createUser(@Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        User user = userService.insertUser(userCreateRequestDto.toEntity());
        return new UserResponseDto(user);
    }

    @GetMapping("/email")
    public ResponseEntity<Boolean> isEmailDuplicated(@RequestParam String email) {
        return ResponseEntity.ok(userService.isEmailDuplicated(email));
    }

}