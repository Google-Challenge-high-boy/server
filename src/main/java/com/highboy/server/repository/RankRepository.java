package com.highboy.server.repository;

import com.highboy.server.controller.rank.dto.FindRankListDto;
import com.highboy.server.domain.rank.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {

    FindRankListDto findRankListBy(LocalDateTime date);

    //@query

    //void deleteByQuestId(Long questId);
}