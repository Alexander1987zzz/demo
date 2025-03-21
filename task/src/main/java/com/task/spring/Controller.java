package com.task.spring;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {
    @Autowired
    private ManRepository repository;

    @PostConstruct
        void init(){
        log.info("???????????????????");
    }

    @GetMapping("/hello")
    ResponseEntity<Man> get(){
        return ResponseEntity.ok(repository.findById(1L).get());
    }
}
