package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p/>
 * 描述: 不允许开空间。
 * 总结：注意相等的情况。[1,9] [8,8]
 */
public class List_21_MergeTwoSortedLists {


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

    /**
     * A recursive solution
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsII(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsII(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        TestUtil.printList(mergeTwoLists(TestUtil.buildList("[1,1,2,45]"), TestUtil.buildList("[2,4,6,9]")));
        TestUtil.printList(mergeTwoListsII(TestUtil.buildList("[1,1,2,45]"), TestUtil.buildList("[2,4,6,9]")));
    }
}
