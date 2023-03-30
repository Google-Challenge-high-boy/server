import com.highboy.server.controller.rank.dto.FindRankListDto;
import com.highboy.server.repository.CustomRankRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class RankRepositoryImpl implements CustomRankRepository {
    //private final JPAQueryFactory queryFactory;
    QRank r = new QRank("r");
    //QMember m = new QMember("m"); USER

    public RankRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<FindRankListDto> findRankList(LocalDateTime date) {
        return queryFactory
                .select(Projections.bean(FindRankListDto.class, r.rank, r.date))
                .from(r)
                .where(r.date.eq(date))
                .fetch();
    }

}
