package com.highboy.server.controller.user.dto;


import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class UserLoginResponseDto {

    private final Boolean success;
    private  final String date;

    public UserLoginResponseDto(Boolean result) {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        this.success = result;
        this.date = simpleDateFormat.format(nowDate);
    }
}