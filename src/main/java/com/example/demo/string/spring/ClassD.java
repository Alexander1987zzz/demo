package com.example.demo.string.spring;

import com.example.demo.string.finterface.A;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClassD {

    private List<A> aList;
    public void go(){

    }
}
