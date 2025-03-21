package com.interview.algoritms;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamNumbers {

    public static void main(String[] args) {
        //необходимо вывести список чисел и их количество, которые повторяются 2 и более раз
        int[] arr = {0, 0, 0, 2, 3, 4, 2, 5, 4, 3, 7, 9, 1};
        Map<Integer, Long> duplicates = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        duplicates.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .forEach(entry -> System.out.println(entry.getKey() + " повторяется " + entry.getValue() + " раз(а)"));
    }

}
