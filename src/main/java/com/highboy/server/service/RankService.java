package com.highboy.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class RankService {
//    @Transactional //단순조회
//    public List<FindRankListDto> findList(String userId, LocalDateTime date) {
        //List<FindQuestListDto> findQuestListDtoList = questRepository.findQuestList(category);
        //List<FindRankListDto> findRankListDtoList = RankRepository.findRankList(date);
        //memberRepository.findByMemberId(memberId);

//        return findRankListDtoList;
//    }

    // 정답일 경우(유사도==100) 서버시간을 저장 => 1시간에 한번씩 서버시간 랭킹에 추가하고 정렬

    // 1시간에 한번씩 랭킹 정렬
}
