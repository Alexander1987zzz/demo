package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Stack;

@SpringBootApplication
public class Main {


    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {

                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (top == '(' && c!= ')') {
                    return false;
                }
                else if (top == '{' && c != '}') {
                    return false;
                }

                else if (top == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");

        System.out.println(isValid("")); // 1 - true
        System.out.println(isValid("()")); // 2 - true
        System.out.println(isValid("(({}[()]))")); // 3 - true
        System.out.println(isValid("(()")); // 4 - false
        System.out.println(isValid("((]")); // 5 - false
        System.out.println(isValid("]")); // 6 - false
        System.out.println(isValid("([)]"));// 7 - false


    }
}