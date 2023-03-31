package com.highboy.server.controller.komantle.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class KomantleAnswerResponseDto {

    private final double similarity;
    private final Map<String,Object> answerList;

    public KomantleAnswerResponseDto(double similarity, Map<String,Object> answerList){
        this.similarity = similarity;
        this.answerList = answerList;
    }
}
