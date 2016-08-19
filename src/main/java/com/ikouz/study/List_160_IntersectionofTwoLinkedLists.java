package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/11 21:40.
 */
public class List_160_IntersectionofTwoLinkedLists {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * <p/>
     * For example, the following two linked lists:
     * <p/>
     * A:-----a1 → a2
     * --------------↘
     * ----------------c1 → c2 → c3
     * --------------↗
     * B:b1 → b2 → b3
     * begin to intersect at node c1.
     * <p/>
     * <p/>
     * Notes:
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     * <p/>
     * 总结：
     * 思路1，求长度差-长的先走-一起到交点；
     * 思路2，同时出发，走到终点后从对方链表头开始走，将会在交点处相遇；
     * <p/>
     * 时间复杂度：2*O(n)
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, k = headB;
        int lenA = 0, lenB = 0;
        while (p != null || k != null) {
            if (p != null) {
                lenA++;
                p = p.next;
            }
            if (k != null) {
                lenB++;
                k = k.next;
            }
        }
        p = headA;
        k = headB;
        int i = lenA - lenB;
        while (i > 0) {
            i--;
            p = p.next;
        }
        while (i < 0) {
            i++;
            k = k.next;
        }
        while (p != null && k != null) {
            if (p == k) {
                return p;
            }
            p = p.next;
            k = k.next;
        }
        return null;
    }
}
