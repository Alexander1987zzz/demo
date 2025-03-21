package com.task.algoritms;

import jakarta.persistence.Version;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.data.jpa.repository.Lock;

import java.util.HashSet;
import java.util.Set;

public class TwoNumbers {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
            System.out.println(result);
        }
        return result;
    }



    public static int singleNumber1(int[] nums) {

        Set<Integer> numbers = new HashSet();

        for(int i : nums){
            if(!numbers.contains(i)){
                numbers.add(i);
            } else {
                numbers.remove(i);
            }

        }return numbers.stream()
                .findFirst().orElse(null);}



        public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 4};

        int result = singleNumber1(nums);
        System.out.println("final " + result);
    }
}
