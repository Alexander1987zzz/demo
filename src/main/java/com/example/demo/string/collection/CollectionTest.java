package com.example.demo.string.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class CollectionTest {
    public static List<String> foo(List<String> strings) {
        //удалить из коллекции все строки, начинающиеся на abc, без создания новой коллекции и без java8, без предикатов

        Iterator<String> i = strings.iterator();
        while (i.hasNext()) {
            String s = i.next().toString();
            if (s.startsWith("abc")) {
                i.remove();
            }

        }

//        strings.removeIf(s -> s.startsWith("abc"));
        return strings;


    }

    public static void main(String[] args) {
        SpringApplication.run(CollectionTest.class, args);

        ArrayList<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("babcd");
        list.add("abce");
        foo(list);
        System.out.println(list);
        SpringApplication.run(CollectionTest.class, args);
    }

}
