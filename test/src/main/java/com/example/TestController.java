package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String test() {
        return "Hello";
    }


    @PostMapping(value = "/get-units", consumes = {"application/x-www-form-urlencoded"})
    public ResponseEntity<String> getUnits(@RequestBody MultiValueMap<String, ?> form) {
        if (form.isEmpty() || form.getFirst("param") == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: Empty values are not allowed");
        }
        // Process the form data
        return ResponseEntity.ok("Units processed successfully");
    }
}
