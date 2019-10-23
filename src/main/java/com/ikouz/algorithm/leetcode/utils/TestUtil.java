package com.ikouz.algorithm.leetcode.utils;

import com.ikouz.algorithm.leetcode.domain.ListNode;
import com.ikouz.algorithm.leetcode.domain.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
        System.out.print("Building List: ");
        printList(head.next);
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
        if (str.length() == 0) {
            return new int[0];
        }
        String[] arr = str.split(",");
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = Integer.valueOf(arr[i].trim());
        }
        return ret;
    }

    public static int[][] buildIntArrArr(String str) {
        if (str == null || !str.startsWith("[[") || !str.endsWith("]]")) {
            return null;
        }
        str = str.replace(" ", "").replace("[[", "").replace("]]", "");
        String[] arrStr = str.split("\\],\\[");

        if (arrStr.length == 0) {
            return new int[0][0];
        }
        int[][] ret = new int[arrStr.length][arrStr[0].split(",").length];
        for (int i = 0; i < arrStr.length; i++) {
            String[] arr = arrStr[i].split(",");
            for (int j = 0; j < arr.length; j++) {
                ret[i][j] = Integer.valueOf(arr[j].trim());
            }
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
        if (arr.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printIntArrArr(int[][] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            printIntArr(arr[i]);
        }
        System.out.println("]");
    }

    /**
     * 初始化二叉树，leetcode规则
     *
     * @param str example: [1,null,2,3]
     * @see "https://leetcode.com/faq/#binary-tree"
     */
    public static TreeNode buildTree(String str) {
        if (str == null || !str.startsWith("[") || !str.endsWith("]")) {
            return null;
        }
        str = str.replace("[", "").replace("]", "");
        String[] arr = str.split(",");
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> dequeS = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!"null".equals(arr[i])) {
                TreeNode treeNode = new TreeNode(Integer.valueOf(arr[i]));
                dequeS.addLast(treeNode);
                deque.addLast(treeNode);
            } else {
                dequeS.addLast(null);
            }
        }
        TreeNode root = dequeS.pollFirst();
        TreeNode tmp;
        while (deque.peekFirst() != null && !dequeS.isEmpty()) {
            tmp = deque.pollFirst();
            if (tmp != null) {
                tmp.left = dequeS.pollFirst();
                tmp.right = dequeS.pollFirst();
            }
        }
        return root;
    }

    /**
     * 广度优先遍历
     *
     * @param root
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head != null) {
                sb.append(head.val).append(",");
                queue.offer(head.left);
                queue.offer(head.right);
            } else {
                sb.append("null,");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        System.out.println(sb);
    }
}
