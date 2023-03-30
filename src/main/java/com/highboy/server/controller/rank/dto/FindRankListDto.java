package com.highboy.server.controller.rank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.description.field.FieldDescription;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FindRankListDto {
    private Integer rank;

    private LocalDateTime date;
}
