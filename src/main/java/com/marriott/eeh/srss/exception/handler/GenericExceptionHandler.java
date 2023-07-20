package com.marriott.eeh.srss.exception.handler;

import brave.Tracer;

import com.marriott.eeh.srss.exception.ErrorResponse;
import com.marriott.eeh.srss.exception.InvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import javax.xml.bind.ValidationException;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GenericExceptionHandler {

    @Autowired
    private Tracer tracer;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception, HandlerMethod handlerMethod) {
        log.error("Exception In method: {} and exception: {}", handlerMethod.getMethod().getName(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildErrorResponse(500, "Unexpected error occurred !"));
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception, HandlerMethod handlerMethod) {
        log.error("Exception In method: {} and exception: {}", handlerMethod.getMethod().getName(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildErrorResponse(400, "Constraint violation exception: " + exception.getMessage()));
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorResponse> handleInvalidDataException(NoSuchElementException exception, HandlerMethod handlerMethod) {
        log.error("Exception In method: {} and exception: {}", handlerMethod.getMethod().getName(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(buildErrorResponse(204, exception.getMessage()));
    }

    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<ErrorResponse> handleInvalidDataException(InvalidDataException exception, HandlerMethod handlerMethod) {
        log.error("Exception In method: {} and exception: {}", handlerMethod.getMethod().getName(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildErrorResponse(400, exception.getMessage()));
    }

    private ErrorResponse buildErrorResponse(int statusCode, String message) {
        return new ErrorResponse(statusCode, message, getTraceId());
    }

    private String getTraceId() {
        return tracer.currentSpan().context().traceIdString();
    }
}
