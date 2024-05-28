package com.example.demo.string;


import com.example.demo.string.spring.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableJpaRepositories
public class StringTest1Application {
    public static void fun1() {
        String str = "Hello";
        System.out.println(str);
        fun2(str);
        System.out.println(str);
    }

    public static void fun2(String str) {
        str += "World";
    }

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(StringTest1Application.class, args);

        fun1();
        SampleService s = context.getBean(SampleService.class);
        s.processData1("rrr");

    }


}
