package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2017/02/06 11:50.
 */
public class List_148_SortList {

    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * <p/>
     * 总结：使用归并排序。
     */
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        int len = 1, step = 0;
        ListNode p = head, m = head;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        if (len < 2) {
            return head;
        } else {
            // 分治
            m = head;
            step = len / 2;
            while (step > 1) {
                step--;
                m = m.next;
            }
            p = m.next;
            m.next = null;
            m = head;
            m = sortList(m);
            p = sortList(p);

            // merge
            ListNode n = new ListNode(-1);
            ListNode nh = n;
            while (m != null || p != null) {
                if (m != null && p != null) {
                    if (m.val < p.val) {
                        n.next = m;
                        m = m.next;
                    } else {
                        n.next = p;
                        p = p.next;
                    }
                } else if (m != null && p == null) {
                    n.next = m;
                    m = m.next;
                } else if (m == null && p != null) {
                    n.next = p;
                    p = p.next;
                }
                n = n.next;
            }
            return nh.next;
        }
    }


    public static void main(String[] args) {
        ListNode list = TestUtil.buildList("[3,2,1,2,3,5,7,8,9,0]");
        TestUtil.printList(sortList(list));
    }
}
