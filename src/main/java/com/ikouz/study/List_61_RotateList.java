package com.ikouz.study;

import com.ikouz.study.domain.ListNode;
import com.ikouz.study.utils.TestUtil;

/**
 * Created by liujiaming on 2017/02/06 10:29.
 */
public class List_61_RotateList {

    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.
     * <p/>
     * For example:
     * Given 1->2->3->4->5->NULL and k = 2,
     * return 4->5->1->2->3->NULL.
     * <p/>
     * 总结：
     * 1. 定位倒数第n个节点，使用相距n步长的两个指针移动。
     * 2. 定位倒数第n个节点，可以先计算出链表长度，然后就可以得出需要移动的步数。
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode m = head, n = head, pm, pn;
        while (k > 0) {
            k--;
            n = n.next;
            if (n == null) {// 相当于一个环，当k大时，效率低!!!!
                n = head;
            }
        }
        if (n == head) {
            return head;
        }
        do {
            pm = m;
            m = m.next;
            pn = n;
            n = n.next;
        } while (n != null);

        pn.next = head;
        pm.next = null;
        return m;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int len = 1;
        ListNode p = head, m = head, pm;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        int step = len - k;
        do {
            pm = m;
            m = m.next;
            step--;
        } while (step > 0);
        pm.next = null;
        p.next = head;
        return m;
    }

    public static void main(String[] args) {
        ListNode list = TestUtil.buildList("[1]");
        TestUtil.printList(rotateRight(list, 4));
        TestUtil.printList(rotateRight2(list, 4));
    }
}
