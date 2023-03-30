package com.highboy.server.repository;

import com.highboy.server.controller.rank.dto.FindRankListResponseDto;
import com.highboy.server.domain.rank.Rank;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {

    @Query(value = "select r from Rank r where r.date = :date")
    List<Rank> findRankByDate(@Param("date") LocalDateTime date);
}