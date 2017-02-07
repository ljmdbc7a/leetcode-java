package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/15 16:11.
 */
public class List_206_ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode k = null;
        ListNode tmp;
        while (p != null) {
            tmp = p;
            p = p.next;
            tmp.next = k;
            k = tmp;
        }
        return k;
    }
}
