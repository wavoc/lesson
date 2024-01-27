package com.example.lesson.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JavobDto {
    private String message;
    private Integer number;
    private String ortichqaField;

    public JavobDto(String message, Integer number, String ortichqaField) {
        this.message = message;
        this.number = number;
        this.ortichqaField = ortichqaField;
    }

    public JavobDto(String message, Integer number) {
        this.message = message;
        this.number = number;
    }

    public JavobDto(String message, String ortichqaField) {
        this.message = message;
        this.ortichqaField = ortichqaField;
        number = 1234;
    }
}
