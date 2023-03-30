package com.highboy.server.controller.rank;

import com.highboy.server.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/rank")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class RankController {
    private final RankService rankService;

    //private final MemberRepository memberRepository;
    // 당일 랭킹, 이전 랭킹 조회 => 당일 랭킹은 1시간에 한 번씩 갱신해야 함
    // 자정에 데이터 초기화 할 때 전날 데이터 db에 저장
//    @GetMapping("")
//    public ResponseEntity findList(@RequestHeader("userId") String userId,
//                                   @RequestParam(name = "date", required = false, defaultValue = "") LocalDateTime date) {
//        Long memberId = userRepository.findByAccountName(jwtUtil.extractUsername(accessToken.substring(7)));
//        log.info(String.valueOf(memberId));
//        return ResponseEntity.status(HttpStatus.OK).body(rankService.findList(userId, date)); //parameter에 userId 추가
//    }
}
