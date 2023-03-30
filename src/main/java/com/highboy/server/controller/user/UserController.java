package com.highboy.server.controller.user;

import com.highboy.server.controller.user.dto.*;
import com.highboy.server.domain.user.User;
import com.highboy.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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
    public UserSimpleResponseDto createUser(HttpServletRequest request, @Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        String email = request.getHeader("userId");

        Boolean result = userService.insertUser(userCreateRequestDto.toEntity(email));

        return new UserSimpleResponseDto(result);
    }

    @PostMapping("/signin")
    public UserLoginResponseDto getUser(HttpServletRequest request) {
        String email = request.getHeader("userId");
        Boolean result = !isEmailDuplicated(email).getBody();
        return new UserLoginResponseDto(result);
    }

    @GetMapping("/email")
    public ResponseEntity<Boolean> isEmailDuplicated(@RequestParam String email) {
        return ResponseEntity.ok(userService.isEmailDuplicated(email));
    }

    @GetMapping("/info")
    public UserInfoResponseDto getUserInfo(@RequestParam String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return new UserInfoResponseDto(user);
    }
}