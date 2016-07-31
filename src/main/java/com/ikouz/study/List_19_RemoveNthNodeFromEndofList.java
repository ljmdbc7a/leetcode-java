package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/07/30 14:42.
 */
public class List_19_RemoveNthNodeFromEndofList {

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * <p/>
     * For example,
     * <p/>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p/>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     * <p/>
     * 总结：双指针。注意边界、特殊情况。
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode p = head, k = head;
        int i = 0;
        while (i < n && k.next != null) {
            k = k.next;
            i++;
        }
        if (i < n - 1) {
            return head;
        } else if (i == n - 1) {
            return head.next;
        }
        while (k.next != null) { // 继续移动p、k
            k = k.next;
            p = p.next;
        }
        // 删除p.next
        p.next = p.next.next;
        return head;
    }

}
