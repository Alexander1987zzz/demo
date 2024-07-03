package com.example.demo.string.spring;

import com.example.demo.string.finterface.A;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class ClassB implements A {

    @PostConstruct
    public void init(){
        System.out.println("ClassB init");
    }
    @Override
    public void fly() {

    }

    @Override
    public void go() {
        A.super.go();
    }


}
