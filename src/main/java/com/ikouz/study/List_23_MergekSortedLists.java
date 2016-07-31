package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/07/30 16:09.
 */
public class List_23_MergekSortedLists {

    /**
     * Merge k sorted linked lists and return it as one sorted list.
     * Analyze and describe its complexity.
     * <p/>
     * 总结：降低复杂度
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        for (int i = 0; i < lists.length; i++) {
            ret = mergeLists(ret, lists[i]);
        }
        return ret;
    }

    private static ListNode mergeLists(ListNode l1, ListNode l2) {
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
