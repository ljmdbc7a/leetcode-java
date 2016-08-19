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
     * 总结：降低复杂度。分治、堆排序。
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        /*
        ListNode ret = null;
        for (int i = 0; i < lists.length; i++) {
            ret = mergeLists(ret, lists[i]);
        }
        return ret;
        */
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsFenzhi(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKListsFenzhi(ListNode[] lists, int i, int j) {
        if (i < j) {
            int m = (i + j) / 2;
            mergeLists(mergeKListsFenzhi(lists, i, m), mergeKListsFenzhi(lists, m, j));
        }
        return lists[i];
    }

    private static ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head, p = l1, k = l2;
        while (p != null || k != null) {
            if (p == null || (k != null && p.val >= k.val)) {
                curr.next = k;
                k = k.next;
            }
            if (k == null || (p != null && p.val < k.val)) {
                curr.next = p;
                p = p.next;
            }
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[0];
        System.out.println(mergeKLists(lists));
    }

}
