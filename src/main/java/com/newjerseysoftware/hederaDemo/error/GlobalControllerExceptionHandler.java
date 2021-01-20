package com.newjerseysoftware.hederaDemo.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.Date;

@EnableWebMvc
@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<?>  handlerInvalidFormatException(Exception ex, WebRequest req){

            Error errorDetails =
                    new Error(
                            new Date(),
                            HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                            ex.getMessage(),
                            req.getDescription(false));

            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<?>  handlerMismatchedInputException(Exception ex, WebRequest req){

        Error errorDetails =
                new Error(
                        new Date(),
                        HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                        ex.getMessage(),
                        req.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

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
