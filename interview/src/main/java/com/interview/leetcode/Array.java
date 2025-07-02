package com.interview.leetcode;

import java.util.*;

public class Array {
    static int[] ints = {1, 5, 6, 7, 9, 11, 12};

    static String inSpaces = "Mr John Smith ";
    static String outIncode = "Mr%20John%20Smith";

    static int[][] meetings = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
    };

    String decodeinput1 = "3[a]2[bc]";
    String decodeinput2 = "3[a2[c]]";
    String decodeinput3 = "2[abc]3[cd]ef";

    static String in = "abcabdd";
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // Создаем остальные узлы и связываем их
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        deleteDuplicates(head);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static int searchInsert(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }

        return map.get(target);
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                list.add(Integer.parseInt(s.charAt(i) + "" + s.charAt(i+1)));
                i++;
            } else {
                list.add(Integer.parseInt(s.charAt(i) +""));
            }
        }
        if (list.size() == 1){
            return false;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (!Objects.equals(list.get(start), list.get(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static int[][]mergeIntervals(int[][] in) {
        if (in.length < 1) {
            return in;
        }
        Arrays.sort(in, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new LinkedList<>();
        int[] current = in[0];
        merged.add(current);

        for (int[] interval : in) {
            int currentEnd = current[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) {
                // Слияние интервалов
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Начинаем новый интервал
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static int getFirstIndex(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (map.get(entry.getKey()) == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static int longestPalindromeLength(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int totalChars = s.length();
        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return totalChars - oddCount + (oddCount > 0 ? 1 : 0);
    }

    public static String decodeString(String str) {
        Stack<Integer> countStack = new Stack<>(); // Стек для хранения чисел
        Stack<StringBuilder> stringStack = new Stack<>(); // Стек для хранения строк
        StringBuilder currentString = new StringBuilder(); // Текущая строка
        int k = 0; // Текущее число повторений

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                // Если символ - цифра, обновляем k
                k += Character.getNumericValue(c); // Обрабатываем многозначные числа
            } else if (c == '[') {
                // Если символ - '[', сохраняем текущее значение k и текущую строку
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder(); // Сбрасываем текущую строку
                k = 0; // Сбрасываем k
            } else if (c == ']') {
                // Если символ - ']', извлекаем из стека и формируем строку
                StringBuilder decodedString = stringStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString); // Повторяем текущую строку
                }
                currentString = decodedString; // Обновляем текущую строку
            } else {
                // Если символ - обычный символ, добавляем его к текущей строке
                currentString.append(c);
            }
        }
        return currentString.toString();
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                if (intervals[index][1] > intervals[i][1]) {
                    intervals[index][1] = intervals[index][1];
                } else {
                    intervals[index][1] = intervals[i][1];
                }
            } else {
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(intervals, index + 1);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Anagrams must have the same length
        }
        int[] charCounts = new int[26]; // Assuming lowercase English letters
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++; // Increment count for s
            charCounts[t.charAt(i) - 'a']--; // Decrement count for t
        }
        for (int count : charCounts) {
            if (count != 0) {
                return false; // If any count is not zero, not an anagram
            }
        }
        return true; // All counts are zero, so it's an anagram
    }

    public static String replaceString(String str) {
        char[] chars = str.toCharArray();
        int counter = 0;
        char[] newChars;
        for (char c : chars) {
            if (c == ' ') {
                counter++;
            }
        }
        if (counter == 0) {
            return str;
        } else {
            newChars = new char[str.length() + counter * 2];
            int j = newChars.length - 1; // Индекс для нового массива
            // Заполнение нового массива с конца
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == ' ') {
                    newChars[j] = '0';
                    newChars[j - 1] = '2';
                    newChars[j - 2] = '%';
                    j -= 3; // Уменьшаем индекс на 3
                } else {
                    newChars[j] = chars[i];
                    j--;
                }
            }
        }
        return str.replaceAll(" ", "%20");
    }

    public static String getArranges(int[] arr) {
        if (arr.length == 0) return "";
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 != arr[i]) {
                if (start == i - 1) {
                    sb.append(arr[start]);
                } else {
                    sb.append(arr[start]).append("-").append(arr[i - 1]);
                }
                sb.append(",");  // Добавляем разделитель
                start = i;
            }
        }

        if (start == arr.length - 1) {
            sb.append(arr[start]);
        } else {
            sb.append(arr[start]).append("-").append(arr[arr.length - 1]);
        }

        return sb.toString();
    }
}
