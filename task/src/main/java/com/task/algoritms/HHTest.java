package com.task.algoritms;

public class HHTest {
    public static void foo(int integers) {
        System.out.println("foo(int)");
    }

    public static void foo(Object object) {
        System.out.println("foo(object)");
    }

    public static void foo(Integer integer) {
        System.out.println("foo(integer)");
    }

    public static void foo(short short1) {
        System.out.println("foo(short)");
    }

    public static void foo(Long long1) {
        System.out.println("foo(long)");
    }

    public static void main(String[] args) {
        foo(10);
    }
}
