package com.highboy.server.controller.rank;

import com.highboy.server.controller.rank.dto.FindRankListDto;
import com.highboy.server.controller.user.dto.UserInfoResponseDto;
import com.highboy.server.domain.rank.Rank;
import com.highboy.server.domain.user.User;
import com.highboy.server.repository.RankRepository;
import com.highboy.server.repository.UserRepository;
import com.highboy.server.service.RankService;
import com.highboy.server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@RequestMapping("/v1/rank")
@RestController
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    private final RankRepository rankRepository;
    private final UserRepository userRepository;
    // 당일 랭킹, 이전 랭킹 조회 => 당일 랭킹은 1시간에 한 번씩 갱신해야 함
    // 자정에 데이터 초기화 할 때 전날 데이터 db에 저장
//    @GetMapping("/current") //전체 랭킹 조회
//    public ResponseEntity findList(@RequestHeader("userId") Long userId,
//                                   @RequestParam(name = "date", required = false, defaultValue = "") LocalDateTime date) {

//        FindRankListDto rank = rankRepository.findRankListBy(date);

        //Optional<User> user = userRepository.findById(userId);

        //return new FindRankListDto(); //parameter에 userId 추가
//    }
}
//ResponseEntity.status(HttpStatus.OK).body(rankService.findList(userId, date))
//    Optional<User> user = userService.getUserById(userId);
//        return new UserInfoResponseDto(user);