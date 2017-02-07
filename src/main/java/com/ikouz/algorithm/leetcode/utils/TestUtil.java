package com.ikouz.algorithm.leetcode.utils;

import com.ikouz.algorithm.leetcode.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/17 16:05.
 */
public class TestUtil {

    public static ListNode buildList(String str) {
        if (str == null || !str.startsWith("[") || !str.endsWith("]")) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        str = str.replace("[", "").replace("]", "");
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            ListNode l = new ListNode(Integer.valueOf(arr[i]));
            p.next = l;
            p = l;
        }
        System.out.println("Build List: " + head.next);
        return head.next;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode p = head;
        StringBuffer sb = new StringBuffer("[");
        while (p != null) {
            sb.append(p.val).append(",");
            p = p.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public static int[] buildIntArr(String str) {
        if (str == null || !str.startsWith("[") || !str.endsWith("]")) {
            return null;
        }
        str = str.replace("[", "").replace("]", "");
        String[] arr = str.split(",");
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = Integer.valueOf(arr[i]);
        }
        return ret;
    }

    public static void printIntArr(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }
}
