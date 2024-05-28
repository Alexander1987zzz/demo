//package com.example.demo.string;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class Iter<T> implements Iterator<T> {
//
//    private final T[] arr;
//
//    private int index;
//
//    private final int end;
//
//
//    public MyIterator(T[] arr) {
//
//        this.arr = arr;
//
//        this.index = 0;
//
//        this.end = arr.length;
//
//    }
//
//
//    @Override
//
//    public boolean hasNext() {
//
//        return index < end;
//
//    }
//
//
//    @Override
//
//    public T next() {
//
//        if (index >= end) {
//
//            throw new NoSuchElementException();
//
//        }
//
//        return arr[index++];
//
//    }
//
//
//    @Override
//
//    public void remove() {
//
//        if (index == 0 || index >= end) {
//
//            throw new IllegalStateException();
//
//        }
//
//        System.arraycopy(arr, index, arr, index - 1, end - index);
//
//        arr[--end] = null;
//
//    }
//
//}
