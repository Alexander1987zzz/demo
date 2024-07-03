package com.example.spring;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SomeOtherService2 {
    public List<String> doSomething(List<String> data) {
        return data;
    }
}
