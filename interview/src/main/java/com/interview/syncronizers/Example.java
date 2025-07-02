package com.interview.syncronizers;

public class Example {

    public synchronized void foo() {
        //do something
        bar();

    }

    public synchronized void bar() {
        //do something
    }
}
