package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/07/30 15:14.
 */
public class List_21_MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * <p/>
     * 描述: 不允许开空间。
     * 总结：注意相等的情况。[1,9] [8,8]
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ret, p, k, t;
        if (l1.val < l2.val) {
            ret = l1;
            p = l1;
            k = l2;
        } else {
            ret = l2;
            p = l2;
            k = l1;
        }
        while (k != null) {
            if (p.next == null) {
                p.next = k;
                return ret;
            }
            if (p.val <= k.val && p.next.val >= k.val) {
                t = k.next;
                k.next = p.next;
                p.next = k;
                k = t;
            }
            p = p.next;
        }
        return ret;
    }
}
