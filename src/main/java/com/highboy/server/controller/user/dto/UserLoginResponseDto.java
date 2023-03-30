package com.highboy.server.controller.user.dto;


import com.highboy.server.domain.user.User;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class UserLoginResponseDto {

    private final Number status;
    private final User user;
    private  final String date;

    public UserLoginResponseDto(User user) {
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        this.status = 200;
        this.user = user;
        this.date = simpleDateFormat.format(nowDate);
    }
}