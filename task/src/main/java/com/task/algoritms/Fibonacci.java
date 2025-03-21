package com.task.algoritms;

public class Fibonacci {
    public static int fibonacci(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));  // Output: 55
        System.out.println(fibonacci(20));  // Output: 6765
        System.out.println(fibonacci(300000000));  // Output: 832040
    }
}
