package com.interview.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

public class PingPong {
    String name;
    Integer num;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void getState(Integer arr, PingPong pong) {
        arr = 2;
        pong.setNum(50);
        pong.setName("F");

    }

    static Integer arr = 1;

    public static void main(String[] args) throws InterruptedException {

        final var pong = new PingPong();
        pong.setName("A");
        pong.setNum(10);
        pong.getState(arr, pong);
        System.out.println(pong.getNum());
        System.out.println(pong.getName());
        System.out.println(arr);


    }

    public static final int counter = 1;
    public static AtomicBoolean flag = new AtomicBoolean(true);

    public static void pingPongWhile() {
        int[] array1 = {1, 2, 3, 4, 5};
        char[] array2 = {'a', 'b', 'c', 'd', 'e'};


        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < array1.length; i++) {
                while (!flag.get()) {
                }
                System.out.println("PING: " + array1[i]);
                flag.set(false);
            }
        });
        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < array2.length; i++) {
                while (flag.get()) {
                }
                System.out.println("PONG: " + array2[i]);
                flag.set(true);
            }
        });
        thread1.start();
        thread2.start();
    }

    private static final Object lock = new Object();
    private static volatile Boolean pingTurn = true; // Флаг для определения, чей ход

    public static void pingPong() {
        int[] array1 = {1, 2, 3, 4, 5};
        char[] array2 = {'a', 'b', 'c', 'd', 'e'};
        Thread thread1 = new Thread(() -> {
            for (int j : array1) {
                synchronized (lock) {
                    if (!pingTurn) { // Ждем, пока не наш ход
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("PING: " + j);
                    pingTurn = false; // Меняем ход
                    lock.notify(); // Уведомляем другой поток
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (char c : array2) {
                synchronized (lock) {
                    if (pingTurn) { // Ждем, пока не наш ход
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("PONG: " + c);
                    pingTurn = true; // Меняем ход
                    lock.notify(); // Уведомляем другой поток
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
