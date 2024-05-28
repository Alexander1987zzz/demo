package com.example.demo.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class Controller {
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestService service1;

    @GetMapping("order")
    public void order(){
       service1.order(1L);
//        Thread t1 = new Thread(() -> {
//
//            service.order(1L);
//            // code goes here.
//        });
//
//
//        Thread t2 = new Thread(() -> {
//            service.order(1L);
//            // code goes here.
//        });
//        t1.start();
//        t2.start();
    }
}
