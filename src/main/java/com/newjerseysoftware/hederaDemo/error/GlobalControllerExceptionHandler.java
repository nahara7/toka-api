package com.newjerseysoftware.hederaDemo.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityViolationExceptionHandler(Exception ex, WebRequest req) {
        Error errorDetails =
                new Error(
                        new Date(),
                        HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                        ex.getMessage(),
                        "duplicate error - user exists");

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception ex, WebRequest req) {
        Error errorDetails =
                new Error(
                        new Date(),
                        HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                        ex.getMessage(),
                        req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
