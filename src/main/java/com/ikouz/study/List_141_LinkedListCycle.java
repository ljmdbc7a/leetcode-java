package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/11 11:51.
 */
public class List_141_LinkedListCycle {

    /**
     * Given a linked list, determine if it has a cycle in it.
     * <p/>
     * Follow up:
     * Can you solve it without using extra space?
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
