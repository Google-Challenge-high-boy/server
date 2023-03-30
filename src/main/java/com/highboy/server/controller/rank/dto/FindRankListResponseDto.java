package com.highboy.server.controller.rank.dto;

import com.highboy.server.domain.rank.Rank;
import com.highboy.server.domain.user.User;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class FindRankListResponseDto {

    private final Rank userRank;
    private final List<Rank> rankList;

    public FindRankListResponseDto(Rank userRank,List<Rank> rankList) {
        this.userRank = userRank;
        this.rankList = rankList;

    }
}
