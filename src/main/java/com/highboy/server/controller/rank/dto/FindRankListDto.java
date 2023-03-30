package com.highboy.server.controller.rank.dto;

import com.highboy.server.domain.rank.Rank;
import com.highboy.server.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.description.field.FieldDescription;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@ToString
public class FindRankListDto {

    private final String userName;

    public FindRankListDto(User entity) {
        this.userName = entity.getName();
    }
}
