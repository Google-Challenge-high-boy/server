package com.highboy.server.domain.rank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.highboy.server.controller.rank.dto.FindRankListDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="rank")
@Entity
@AllArgsConstructor
@Builder
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rank")
    private Integer rank;
    //왜 여기에는 column 따로 안 붙힘?

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime date;

    public void update(FindRankListDto findRankListDto) {
        this.rank = findRankListDto.getRank();
        this.date = findRankListDto.getDate();
    }
}
