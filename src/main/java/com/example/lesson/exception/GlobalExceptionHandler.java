package com.example.lesson.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<?> ozimizHandleQildik(CustomException exception) {

        String message = exception.getMessage();

        return new ResponseEntity<>(message, HttpStatusCode.valueOf(404));

    }



}
