package com.example.demo.string;


import com.example.demo.string.iterator.MyIterator;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StringTest2Application {
    public static void fun1() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

    }

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(StringTest2Application.class, args);

        fun1();


        List<Integer> lists = Arrays.asList(1, 2, 3);
        MyIterator<Integer> iterator = new MyIterator(lists.size());

        while (iterator.hasNext()) {

            int i = iterator.next();

            System.out.println(i);

        }


    }


    public class Node {
        long id;
        Long parentId;
        List<Node> children;
    }

//    class Test {
//        public void someMethod() {
//            List<Node> treeList = getList();
//        }
//    }


}


