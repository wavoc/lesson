package com.example.lesson.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OddiyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    @Column(name = "date_of_bitrh", length = 1000)
    private String birthDate;
//    @Column(columnDefinition = "true")
    private Boolean deleted = true;
    private LocalDateTime create = LocalDateTime.now();
}
