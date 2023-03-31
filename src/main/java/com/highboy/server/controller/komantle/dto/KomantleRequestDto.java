package com.highboy.server.controller.komantle.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class KomantleRequestDto {

    @NotNull(message = "정답이 필요합니다.")
    private String answer;

    private int count;


    @Builder
    public KomantleRequestDto(@NonNull String answer,int count
    ) {
        this.answer = answer;
        this.count = count;
    }
}
