package com.interview.aston;

import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RunOrStart {
    public static String getAbsolutePath(String inputPath) {
        String[] list = inputPath.split("/");
        Stack<String> stack = new Stack<>();
        for (String s: list)
        {
            if (s == "..")
            {
                stack.pop();
                continue;
            }
            if (s != ".")
            {
                stack.push(s);
            }
        }
        return   String.join("/", stack);

    }

    public static void main(String[] args) {

        System.out.println(getAbsolutePath("/var/check/../../test5/oneMoreExample"));

    }



}
