package com.highboy.server.response;

import lombok.Getter;

@Getter
public class ErrorResponse extends RuntimeException{
    private final int status;

    public ErrorResponse(int status, String message) {
        super(message);
        this.status = status;
    }
}