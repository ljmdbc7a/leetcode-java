package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/11 11:42.
 */
public class List_83_RemoveDuplicatesfromSortedList {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * <p/>
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                // del p.next
                p.next = p.next.next;
            } else {
                // move p to next
                p = p.next;
            }
        }
        return head;
    }
}
