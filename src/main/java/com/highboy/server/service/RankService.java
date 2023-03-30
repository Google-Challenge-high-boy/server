package com.highboy.server.service;

import com.highboy.server.domain.rank.Rank;
import com.highboy.server.repository.RankRepository;
import com.highboy.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class RankService {

    private final UserRepository userRepository;

    private final RankRepository rankRepository;
    @Transactional //단순조회
    public List<Rank> findList(LocalDateTime date) {
         List<Rank> rankList = rankRepository.findRankByDate(date);
        return rankList;
    }

    // 정답일 경우(유사도==100) 서버시간을 저장 => 1시간에 한번씩 서버시간 랭킹에 추가하고 정렬

    // 1시간에 한번씩 랭킹 정렬
}
