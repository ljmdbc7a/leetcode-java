package com.ikouz.study;

import com.ikouz.study.domain.ListNode;

/**
 * Created by liujiaming on 2016/08/17 16:36.
 */
public class List_237_DeleteNodeinaLinkedList {

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * <p/>
     * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
     */
    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
