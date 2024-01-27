package com.example.lesson.controller;

import com.example.lesson.model.dto.JavobDto;
import com.example.lesson.model.dto.OddiyDto;
import com.example.lesson.service.LogicService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LessonController {
    public LessonController(LogicService logicService) {
        this.logicService = logicService;
    }
    private final LogicService logicService;

    @PostMapping("/test")
    public ResponseEntity<?> testMethod(@RequestBody OddiyDto body) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Yes", "Yes");
        return new ResponseEntity<>(logicService.doLogic(body), httpHeaders, 200);
//        return ResponseEntity.ok("");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(logicService.getById(id));
    }

    @PostMapping("/find")
    public ResponseEntity<?> find(@RequestBody OddiyDto body) {
        return ResponseEntity.ok(logicService.findByNandS(body.getName(), body.getSurname()));
    }

    @PostMapping("/findAll")
    public ResponseEntity<?> findAll(@RequestParam String name) {
        return ResponseEntity.ok(logicService.getAll(name));
    }

}
