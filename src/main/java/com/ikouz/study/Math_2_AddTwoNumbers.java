package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/07/16 22:44.
 */
public class Math_2_AddTwoNumbers {

    /**
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p/>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2;
        ListNode r = new ListNode(0);
        ListNode ret = r;
        int m = 0, n;
        while (i != null || j != null || m != 0) {
            int a = i != null ? i.val : 0;
            int b = j != null ? j.val : 0;
            n = (a + b + m) % 10;
            r.next = new ListNode(n);
            r = r.next;
            m = (a + b + m) / 10;
            i = i != null ? i.next : i;
            j = j != null ? j.next : j;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2);
        System.out.print(sum);
    }
}
