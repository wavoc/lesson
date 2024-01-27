package com.example.lesson.service;

import com.example.lesson.exception.CustomException;
import com.example.lesson.model.dto.OddiyDto;
import com.example.lesson.model.dto.JavobDto;
import com.example.lesson.model.entity.OddiyEntity;
import com.example.lesson.repository.SimpleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogicService {

    private final SimpleRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final RestTemplate restTemplate;

    public OddiyEntity doLogic(OddiyDto dto) {
        OddiyEntity entity = new OddiyEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthDate("2024-01-27");
        entity = repository.save(entity);
//        repository.
        return entity;
    }

    public OddiyEntity getById(Long id) {
        Optional<OddiyEntity> optionalOddiyEntity = repository.findById(id);
        if (optionalOddiyEntity.isPresent()) {
            return optionalOddiyEntity.get();
        } else {
            throw new CustomException("Topilmadi");
        }
    }

    public OddiyEntity findByNandS(String name, String surname) {
        var optional = repository.findByNameAndSurname(name, surname);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new CustomException("Topilmadi");
        }
    }

    public OddiyEntity get(String name, String surname) {
        return repository.getByNameAndSurname(name, surname);
    }

    public List<OddiyEntity> getAll(String name) {
        return repository.findAllByName(name);
    }

    public void justMethod() {
        String sql = "select * from";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        String name = String.valueOf(result.get("name"));
        String name1 = (String) result.get("name");
    }

    private void method() {
        String requestBody = "";
        ResponseEntity<OddiyEntity> response = restTemplate.postForEntity("localhost:8080", requestBody, OddiyEntity.class);
    }
}
