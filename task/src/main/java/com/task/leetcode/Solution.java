package com.task.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < l1.; i++){
            sum1 += l1.get(i);
        }

        for (int k = 0; k < l2.size(); k++){
            sum2 += l2.get(i);
        }

        int twoSum = sum1 + sum2;
        String stringSum = String.valueOf(twoSum);
        ListNode node = null;
        for (int j = 0; j < stringSum.toCharArray().length; j++){
            node = new ListNode(j);
        }
        return node;
    }

   public static class ListNode {
     int val;
     ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {

    }

}





