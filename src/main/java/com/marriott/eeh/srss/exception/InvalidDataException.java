package com.marriott.eeh.srss.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String message){
        super(message);
        log.error(message);
    }
    public InvalidDataException(String message, Throwable cause){
        super(message, cause);
    }
}
