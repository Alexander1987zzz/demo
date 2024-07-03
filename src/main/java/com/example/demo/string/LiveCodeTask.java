package com.example.demo.string;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

@SpringBootApplication
public class LiveCodeTask {
//    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//
//
//
//    Example 1:
//
//    Input: nums = [3,0,1]
//    Output: 2
//    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
//    Example 2:
//
//    Input: nums = [0,1]
//    Output: 2
//    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
//    Example 3:
//
//    Input: nums = [9,6,4,2,3,5,7,0,1]
//    Output: 8
//    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.


    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return n;
        }
    }

    //написать функцию которая сравнит два массива
    static int[] arr1 = {1, 2, 3};
    static int[] arr2 = {1, 2, 4};


    boolean resultB = Arrays.equals(arr1, arr2);
    static boolean result = true;

    //написать функцию которая сравнит два массива

    public static boolean compare(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }


        if (arr1 == null)
            for (int i = 0; i < arr1.length; i++) {

                if (arr1[i] != arr2[i]) {

                    result = false;
                    break;
                }
            }
        return result;
    }




//каталоги
//пользователь ходит по каталогам
//Например: /var/lib/././../test/../check/result
//Необходимо вычислить конечный путь:
// /var/check/result

//Еще пару примеров
//1.
//Вход: /var/././test/anotherExample
//Выход: /var/test/anotherExample
//2.
//Вход: /var/check/../../oneMoreExample
//Выход: /oneMoreExample

//todo решение задачи

    public static String getAbsolutePath(String inputPath) {
        //решение
        String[] directories = inputPath.split("/");
        Stack<String> stack = new Stack<>();


        for (String directory : directories) {
            if (directory.equals(".")) {
                continue;

            } else if (directory.equals("..")) {
                stack.pop();
            } else
                stack.push(directory);
        }
        stack.stream().collect(Collectors.joining("/"));
        return String.join("/", stack);
    }

    //задача со скобками



    public static void main(String[] args) {


//        System.out.println(getAbsolutePath("/var/check/../../test/oneMoreExample"));




    }
}
