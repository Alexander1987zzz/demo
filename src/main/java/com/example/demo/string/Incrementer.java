package com.example.demo.string;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Incrementer {

    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int task = 200;

        CountDownLatch latch = new CountDownLatch(task * 2);
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        for (int i = 0; i < task; i++) {

            executorService1.submit(() -> {

                counter1++;
                latch.countDown();

            });

            executorService2.submit(() -> {
                counter2++;
                latch.countDown();

            });

        }

        latch.await();
        System.out.println(counter1);
        System.out.println(counter2);


    }
}
