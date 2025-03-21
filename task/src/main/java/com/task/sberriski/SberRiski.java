package com.task.sberriski;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SberRiski {

    //дан массив заполненный уникальными сзачениями типа int,необходимо найти элемент больше всех но меньше касимального
    int[] array = {4, 2, 9, 6, 5, 1, 8, 3, 7};


    public static boolean areArraysDifferent(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return true;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean areArraysEqual(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    public static boolean haveSameElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            set2.add(num);
        }

        return set1.equals(set2);
    }

    public static int findSecondMax1(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax) {
                secondMax = array[i];
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("В массиве нет второго по величине элемента");
            return Integer.MIN_VALUE;
        } else {
            return secondMax;
        }
    }


    public static int findSecondMaxSort(int[] array) {
        if (array.length < 2) {
            System.out.println("В массиве нет второго по величине элемента");
            return Integer.MIN_VALUE;
        }

        Arrays.sort(array);
        return array[array.length - 2];
    }


    public static int findSecondMax(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Exception");
        }

        int index = findMax(array);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (i != index && array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static int findMax(int[] array) {
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 9, 6, 5, 1, 8, 3, 7, 10};
        System.out.println(findMax(array));
//        int secondMax = findSecondMax(array);
//        int secondMaxSort = findSecondMaxSort(array);
//        System.out.println("Второй по величине элемент: " + secondMax);
//        System.out.println("Второй по величине элемент: " + secondMaxSort);
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 3, 2};
        System.out.println(haveSameElements(array1, array2));
//        //порядок важен
//        System.out.println(areArraysDifferent(array1, array2));
//        System.out.println(!Arrays.equals(array1, array2));
//        System.out.println(!Arrays.stream(array1).allMatch(x -> Arrays.stream(array2).anyMatch(y -> x == y)));
//        //порядок не важен
//        System.out.println(areArraysEqual(array1, array2));
//        System.out.println(Arrays.stream(array1).distinct().count() != Arrays.stream(array2).distinct().count());
//        System.out.println(!Arrays.stream(array1).allMatch(x -> Arrays.stream(array2).anyMatch(y -> x == y)));


    }


}
