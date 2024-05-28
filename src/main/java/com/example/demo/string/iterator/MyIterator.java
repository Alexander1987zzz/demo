package com.example.demo.string.iterator;

public class MyIterator<T> {

    private int currentValue = 0;

    private final int endValue;


    public MyIterator(int endValue) {

        this.endValue = endValue;

    }


    public boolean hasNext() {

        return currentValue < endValue;

    }


    public int next() {

        return currentValue++;

    }

}
