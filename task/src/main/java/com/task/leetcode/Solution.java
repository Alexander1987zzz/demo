package com.task.leetcode;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    @Data
    @Accessors(chain = true)
    static
    class Dto{
         String from;
         String to;
     }


    public static char[] getChar(char[] chars, int length) {
        // First, count the number of spaces
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        // Calculate the new length after replacement
        int newLength = length + spaceCount * 2;

        // Ensure the array has enough space (if not, create a new one)
        if (chars.length < newLength) {
            char[] newChars = new char[newLength];
            System.arraycopy(chars, 0, newChars, 0, length);
            chars = newChars;
        }

        // Replace spaces starting from the end
        int newIndex = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[newIndex--] = '0';
                chars[newIndex--] = '2';
                chars[newIndex--] = '%';
            } else {
                chars[newIndex--] = chars[i];
            }
        }

        return chars;}

     public static Dto getDto(List<Dto> dtos){
         Set<String> to = dtos.stream().map(Dto::getTo).collect(Collectors.toSet());
         Set<String> from = dtos.stream().map(Dto::getFrom).collect(Collectors.toSet());
         String first = dtos.stream().map(Dto::getFrom).filter(e -> !to.contains(e)).findFirst().get();
         String last = dtos.stream().map(Dto::getTo).filter(e -> !from.contains(e)).findFirst().get();

         return new Dto().setFrom(first).setTo(last);
     }

    public static void main(String[] args) {
       List<Dto> dtos = new ArrayList<>();
       dtos.add(new Dto().setFrom("London").setTo("Moskow"));
       dtos.add(new Dto().setFrom("NY").setTo("London"));
       dtos.add(new Dto().setFrom("Moskow").setTo("Spb"));
        System.out.println(getDto(dtos));
        char[] chars = {'r',' ','u','k','l'};
        System.out.println(getChar(chars, 4));
    }

//    char заменить на %20
//    марштрут

}





