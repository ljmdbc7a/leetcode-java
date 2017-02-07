package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2016/08/19 10:54.
 */
public class List_147_InsertionSortList {

    /**
     * Sort a linked list using insertion sort.
     * <p/>
     * 总结：插入排序，注意设置好前序指针，方便插入。
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nhead = new ListNode(-1), p = head.next, m, tmp;
        nhead.next = head;
        head.next = null;
        while (p != null) {
            m = nhead;
            tmp = p.next;
            while (m.next != null) {
                if (m.next.val > p.val) {
                    p.next = m.next;
                    m.next = p;
                    break;
                } else {
                    m = m.next;
                }
            }
            // 检查，如果没有插入，则追加到后面
            if (m.next == null) {
                p.next = m.next;
                m.next = p;
            }
            p = tmp;
        }
        return nhead.next;
    }

    public static void main(String[] args) {
        ListNode list = TestUtil.buildList("[2,4,5,0,1]");
        TestUtil.printList(insertionSortList(list));
    }
}
