package com.example.demo.string.spring;

@FunctionalInterface
public interface A {
    void fly();
    private void begin(){
        System.out.println("begin");
    }
    default void go(){};
    static void doing(){
        System.out.println("doing");
    };
}