package com.highboy.server.exception;
import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException( String message) {
        super(message);
    }
}