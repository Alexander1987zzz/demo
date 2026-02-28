package com.interview;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algoritms {
    public static boolean isSubsequence(String s1, String s2) {
        int sIndex = 0;


        for (int i = 0; i < s2.length() && sIndex < s1.length(); i++) {
            if (s1.charAt(sIndex) == s2.charAt(i)) {
                sIndex++;
            }
        }

        return sIndex == s1.length();
    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted((a, b) -> {
                    if (a < 0 && b < 0) {

                        return Integer.compare(b, a);
                    } else if (a >= 0 && b >= 0) {

                        return Integer.compare(a, b);
                    }
                    else {

                        return a < 0 ? -1 : 1;
                    }
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, -2, 3, -1, 0, -4, 2, -3, 1, -5, 4);

        List<Integer> negatives = numbers.stream()
                .filter(x -> x < 0)
                .sorted(Comparator.reverseOrder())
                .toList();
        List<Integer> zero = numbers.stream()
                .filter(x -> x == 0)
                .sorted()
                .toList();
        List<Integer> positive = numbers.stream()
                .filter(x -> x > 0)
                .sorted()
   .toList();

        List<Integer> list = Stream.of(negatives, zero, positive).flatMap(Collection::stream)
                .toList();
        System.out.println("тест" + list);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Отсортированный: " + sortNumbers(numbers));
        // Тестовые примеры
//        System.out.println(isSubsequence("abc", "attbjkc")); // true
//        System.out.println(isSubsequence("abc", "acb"));     // false
//        System.out.println(isSubsequence("ace", "abcde"));   // true
//        System.out.println(isSubsequence("a", "b"));         // false
//        System.out.println(isSubsequence("", "abc"));        // true
    }
}
