package com.highboy.server.repository;

import com.highboy.server.domain.rank.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long>, CustomRankRepository {

    //Rank findByQuestId(Long questId);

    //void deleteByQuestId(Long questId);
}
