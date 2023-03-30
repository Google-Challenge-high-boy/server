package com.highboy.server.domain.rank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.highboy.server.controller.rank.dto.FindRankListDto;
import com.highboy.server.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id"), insertable = false , updatable = false)
    private User user;

}
