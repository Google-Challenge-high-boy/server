package com.highboy.server.controller.user;

import com.highboy.server.controller.user.dto.*;
import com.highboy.server.domain.user.User;
import com.highboy.server.response.ErrorResponse;
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
    public UserSimpleResponseDto createUser(@Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        userService.insertUser(userCreateRequestDto.toEntity());
        return new UserSimpleResponseDto();
    }

    @PostMapping("/signin")
    public UserLoginResponseDto getUser(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) {
        String email = userLoginRequestDto.getEmail();
        User user = userService.getUserByEmail(email).orElseThrow(() -> new ErrorResponse(400, "로그인에 실패했습니다."));
        return new UserLoginResponseDto(user);
    }

    @GetMapping("/email")
    public ResponseEntity<Boolean> isEmailDuplicated(@RequestParam String email) {
        return ResponseEntity.ok(userService.isEmailDuplicated(email));
    }

    @GetMapping("/info")
    public UserInfoResponseDto getUserInfo(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getHeader("userId"));
        Optional<User> user = userService.getUserById(userId);
        return new UserInfoResponseDto(user);
    }
}