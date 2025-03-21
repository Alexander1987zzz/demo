package com.interview.algoritms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber {
//    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.//
//    You must implement a solution with a linear runtime complexity and use only constant extra space.


    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static int singleNumberUsingSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }


    public static int singleNumberUsingMap(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static int singleNumberUsingSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumberUsingSet(nums1));
        System.out.println(singleNumberUsingSet(nums2));
        System.out.println(singleNumberUsingMap(nums1));
        System.out.println(singleNumberUsingMap(nums2));
        System.out.println(singleNumberUsingSorting(nums1));
        System.out.println(singleNumberUsingSorting(nums2));
    }
}
