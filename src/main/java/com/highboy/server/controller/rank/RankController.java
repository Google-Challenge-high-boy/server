package com.highboy.server.controller.rank;

import com.highboy.server.controller.rank.dto.FindRankListResponseDto;
import com.highboy.server.domain.rank.Rank;
import com.highboy.server.repository.RankRepository;
import com.highboy.server.repository.UserRepository;
import com.highboy.server.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/v1/rank")
@RestController
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    private final RankRepository rankRepository;
    private final UserRepository userRepository;
    // 당일 랭킹, 이전 랭킹 조회 => 당일 랭킹은 1시간에 한 번씩 갱신해야 함
    // 자정에 데이터 초기화 할 때 전날 데이터 db에 저장
    @GetMapping("/current") //전체 랭킹 조회
    public FindRankListResponseDto findList(@RequestHeader("userId") Long userId,
                                            @RequestParam(name = "date", required = false, defaultValue = "") LocalDateTime date) {
        List<Rank> rankList = rankService.findList(date);
        Rank myRank = (Rank) rankList.stream().filter((rank)-> rank.getUserId().getId() == userId);
        return new FindRankListResponseDto(myRank,rankList);
    }
}
//ResponseEntity.status(HttpStatus.OK).body(rankService.findList(userId, date))
//    Optional<User> user = userService.getUserById(userId);
//        return new UserInfoResponseDto(user);