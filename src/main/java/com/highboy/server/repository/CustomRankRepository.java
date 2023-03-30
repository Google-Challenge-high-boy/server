package com.highboy.server.repository;

import com.highboy.server.controller.rank.dto.FindRankListDto;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomRankRepository {
    List<FindRankListDto> findRankList(LocalDateTime date);

    FindRankListDto findRankListBy(LocalDateTime date);

}
