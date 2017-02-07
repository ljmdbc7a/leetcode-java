package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/18 11:21.
 */
public class List_92_ReverseLinkedListII {

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * <p/>
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * <p/>
     * return 1->4->3->2->5->NULL.
     * <p/>
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list.
     * <p/>
     * 总结：
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        int max = m > n ? m : n;
        int min = m > n ? n : m;
        int i = 0;
        while (i < max) {

            i++;
        }
        return null;
    }
}
