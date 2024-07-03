package com.example.demo.string.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class BracesTest {

    public static boolean isValid(String input) {

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c)) {

                // одна из открывающих скобок
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                // одна из закрывающих скобок
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        // в конце стек должен быть пустым
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (bracket == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (bracket == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }


    public static boolean isValid2(String s) {
        int square = 0;
        int curly = 0;
        int simply = 0;

        char[] buffer = s.toCharArray();

        for (int i = 0; i < buffer.length; i++) {
            switch (buffer[i]) {
                case '(':
                    simply++;
                    break;
                case ')':
                    simply--;
                    break;
                case '[':
                    square++;
                    break;
                case ']':
                    square--;
                    break;
                case '{':
                    curly++;
                    break;
                case '}':
                    curly--;
                    break;
            }
        }

        return simply == 0 && square == 0 && curly == 0;

    }


    public static boolean isValid3(String s) {
        int square = 0;
        int curly = 0;
        int simply = 0;

        char[] buffer = s.toCharArray();

        for (int i = 0; i < buffer.length; i++) {
            switch (buffer[i]) {
                case '(':
                    simply++;
                    break;
                case ')':
                    if (simply < 1) return false;
                    simply--;
                    break;
                case '[':
                    square++;
                    break;
                case ']':
                    if (square < 1) return false;
                    square--;
                    break;
                case '{':
                    curly++;
                    break;
                case '}':
                    if (curly < 1) return false;
                    curly--;
                    break;
            }
        }

        return simply == 0 && square == 0 && curly == 0;

    }

    public static void main(String[] args) {
        SpringApplication.run(BracesTest.class, args);

        System.out.println(isValid("")); // 1 - true
        System.out.println(isValid("()")); // 2 - true
        System.out.println(isValid("(({}[()]))")); // 3 - true
        System.out.println(isValid("(()")); // 4 - false
        System.out.println(isValid("((]")); // 5 - false
        System.out.println(isValid("]")); // 6 - false
        System.out.println(isValid("([)]")); // 7 - false

    }
}
