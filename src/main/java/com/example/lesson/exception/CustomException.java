package com.example.lesson.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
