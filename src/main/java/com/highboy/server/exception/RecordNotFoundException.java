package com.highboy.server.exception;
import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {

    private final  int status;
    public RecordNotFoundException(int status, String message) {
        super(message);
        this.status = status;
    }
}