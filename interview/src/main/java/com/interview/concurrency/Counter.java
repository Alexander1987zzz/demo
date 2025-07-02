package com.interview.concurrency;

import java.util.concurrent.CountDownLatch;

public class Counter {
    private static int counter = 0;
    private static final int THREADS = 10;
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREADS);

        for (int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    counter++;
                }
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("Expected: " + (THREADS * ITERATIONS) + ", Actual: " + counter);
    }

}
