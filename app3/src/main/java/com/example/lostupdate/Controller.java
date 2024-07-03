package com.example.lostupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    TestService1 testService1;
    @Autowired
    TestService2 testService2;


    @GetMapping({"order"})
    public void order(@RequestParam Long id, @RequestParam Integer quantity) {
        Thread thread1 = new Thread(() -> {
            this.testService1.update(id, quantity);
        });
        Thread thread2 = new Thread(() -> {
            this.testService2.update(id, quantity);
        });
        thread1.start();
        thread2.start();
    }
}