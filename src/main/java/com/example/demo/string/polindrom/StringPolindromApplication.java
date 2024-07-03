package com.example.demo.string.polindrom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringPolindromApplication {
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean isPalindrome2(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }

        }

        return true;


//        for( int i = 0; i < n/2; i++ )
//            if (str.charAt(i) != str.charAt(n-i-1)) return false;
//        return true;
    }


    //написать функцию которая проверит строку является ли она полиндромом
    public static void main(String[] args) {
        SpringApplication.run(StringPolindromApplication.class, args);
        String str1 = "ПОТОП";
        String str2 = "МОРЕ";
        String strBuf3 = "1";

//        System.out.println(isPalindrome(str1));
//        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome2(str1));
        System.out.println(isPalindrome2(str2));

//
//        Stream.of(new Order(1, "1"), new Person(2, "2"))
//                .map(Objects::toString)
//                .peek(System.out::println)
//                .peek(System.out::println)
//                .filter(s -> s.startsWith("2"))
//                .forEach(System.out::println);

    }


}
