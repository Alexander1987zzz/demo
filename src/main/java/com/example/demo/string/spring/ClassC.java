package com.example.demo.string.spring;

import org.springframework.stereotype.Component;

@Component
public class ClassC implements A {
    @Override
    public void fly() {

    }

    @Override
    public void go() {
        A.super.go();
    }
}