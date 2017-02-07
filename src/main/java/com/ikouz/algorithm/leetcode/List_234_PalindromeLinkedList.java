package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2016/08/15 16:26.
 */
public class List_234_PalindromeLinkedList {

    /**
     * Given a singly linked list, determine if it is a palindrome.
     * <p/>
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     * <p/>
     * 总结：思路1：找到中间位置，翻转后半段，然后对比两个半段；
     * 思路2：如果为奇数个item，删除中间item，然后使用bad思路解决；
     * <p/>
     * bad：把list翻转，过程中看做stack，匹配则弹出。翻转完成后，翻转list为空则是回文。----无法解决：[1,2,0,2,1]
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode tmp, k = null, m = head;
        p = head;
        int mid = len / 2 + len % 2;
        int i = 0;
        while (i < mid) {
            m = m.next;
            i++;
        }
        // 翻转m
        while (m != null) {
            tmp = m;
            m = m.next;
            tmp.next = k;
            k = tmp;
        }
        //对比k & p
        while (k != null && p != null) {
            if (k.val != p.val) {
                return false;
            }
            k = k.next;
            p = p.next;
        }
        return true;
    }

    public static boolean badIdea(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p = head, tmp;
        ListNode k = null;
        while (p != null) {
            tmp = p;
            p = p.next;
            if (k != null && tmp.val == k.val) {
                // pop
                k = k.next;
            } else {
                // push
                tmp.next = k;
                k = tmp;
            }
        }
        return k == null;
    }

    public static void main(String[] args) {
        ListNode head = TestUtil.buildList("[1,2,1,2,1]");
        TestUtil.printList(head);
        System.out.println(isPalindrome(head));
    }
}
