package com.task.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {

    private List<String> data = new ArrayList<>();

    @Autowired
    private SomeOtherService1 someOtherService1;

    @Autowired
    private SomeOtherService2 someOtherService2;

    public SampleService() {
        someOtherService1.doSomething(number);
    }

    public static int number = 10;

    @Cacheable("dataCache")
    public List<String> processData1(String input) {
        data.add(input);
        return processData2(data);
    }

    @Transactional
    public List<String> processData2(List<String> data) {
        someOtherService1.doSomethingElse(data);
        return someOtherService2.doSomething(data);
    }
}