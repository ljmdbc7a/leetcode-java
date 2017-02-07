package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2017/02/06 19:00.
 */
public class List_143_ReorderList {


    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * <p/>
     * You must do this in-place without altering the nodes' values.
     * <p/>
     * For example,
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     * <p/>
     * 总结: 对后半段list反转。
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 反转后半段 list 得到 k：Ln → Ln-1 → Ln-2 → …
        int len = 0;
        ListNode p = head, k = null, tmp;
        while (p != null) {
            len++;
            p = p.next;
        }
        int step = len / 2;
        p = head.next;
        while (step > 0) {
            if (step == 1) {
                tmp = p;
                p = p.next;
                tmp.next = null;
            } else {
                p = p.next;
            }
            step--;
        }

        while (p != null) {
            tmp = p.next;
            p.next = k;
            k = p;
            p = tmp;
        }

        // 合并p和k
        p = head;
        ListNode ret = new ListNode(0);
        tmp = ret;
        while (p != null || k != null) {
            if (p != null) {
                tmp.next = p;
                p = p.next;
                tmp = tmp.next;
            }
            if (k != null) {
                tmp.next = k;
                k = k.next;
                tmp = tmp.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode list = TestUtil.buildList("[1,2,5,3,4]");
        reorderList(list);
        TestUtil.printList(list);
    }
}
