package com.highboy.server.controller.komantle.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class KomantleResponseDto {

    private final Map<String, Object> answerList;


    public KomantleResponseDto(Map<String, Object> answerList) {
        this.answerList = answerList;
    }

}

