package com.example.lesson.repository;

import com.example.lesson.model.entity.OddiyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SimpleRepository extends JpaRepository<OddiyEntity, Long> {
    Optional<OddiyEntity> findByNameAndSurname(String name, String surname);

    OddiyEntity getByNameAndSurname(String name, String surname);

    List<OddiyEntity> findAllByName(String name);
}
