package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/15 15:56.
 */
public class List_203_RemoveLinkedListElements {

    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p/>
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     * Return: 1 --> 2 --> 3 --> 4 --> 5
     * <p/>
     * 总结：
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode p = new ListNode(0);
        ListNode pre = p;
        p.next = head;
        while (p.next != null) {
            if (p.next.val == val) {
                // del p.next
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return pre.next;
    }
}
