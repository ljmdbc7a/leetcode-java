package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/07/30 17:58.
 */
public class List_24_SwapNodesinPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p/>
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * <p/>
     * Your algorithm should use only constant space.
     * You may not modify the values in the list, only nodes itself can be changed.
     * <p/>
     * 总结：移动指针时注意判null
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode m = pre, p = head, k = head.next;
        while (p != null && k != null) {
            m.next = p.next;
            p.next = k.next;
            k.next = p;
            // 移动指针 m -> p -> k
            if (p.next != null && p.next.next != null) {
                m = p;
                p = m.next;
                k = p.next;
            } else {
                break;
            }
        }
        return pre.next;
    }

}
