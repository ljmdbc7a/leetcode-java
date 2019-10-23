package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsFenzhi(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKListsFenzhi(ListNode[] lists, int i, int j) {
        if (i < j) {
            int m = (i + j) / 2;
            return mergeLists(mergeKListsFenzhi(lists, i, m), mergeKListsFenzhi(lists, m + 1, j));
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
            if (p == null && k != null) {
                curr.next = k;
                k = k.next;
            }
            if (k == null && p != null) {
                curr.next = p;
                p = p.next;
            }
            if (k != null && p != null) {
                if (p.val >= k.val) {
                    curr.next = k;
                    k = k.next;
                } else {
                    curr.next = p;
                    p = p.next;
                }
            }
            curr = curr.next;
        }
        return head.next;
    }

    /**
     * @param lists
     * @return
     */
    public static ListNode mergeKListsUsePriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            tail.next = top;
            tail = top;
            if (top.next != null) {
                queue.add(top.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = TestUtil.buildList("[1,10,20,40,60]");
        ListNode listNode2 = TestUtil.buildList("[1,11,21,41,61]");
        ListNode listNode3 = TestUtil.buildList("[1,12,22,42,62]");
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};
        TestUtil.printList(mergeKLists(lists));
//        TestUtil.printList(mergeKListsUsePriorityQueue(lists));
    }

}
