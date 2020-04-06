package com.ikouz.algorithm.leetcode;

/**
 * Design a stack that supports push, pop, top, and retrieving
 * the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 *
 * @author liujiaming
 * @since 2020/04/05
 *
 * 两个思路：
 *
 * 1. 设计一个 Node 携带最小值。
 * n -> n-1 -> n-2 -> ... -> 1
 * 操作链表的 n 节点，实现 pop push 操作。
 *
 * 2. 用另外一个 tack 存储对应位置最小值。
 *
 */
public class Stack_155_MinStack {

    NodeWithMin head;

    /** initialize your data structure here. */
    public Stack_155_MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new NodeWithMin(x, x, null);
        } else {
            head = new NodeWithMin(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        } else {
            return 0;
        }
    }

    public int getMin() {
        if (head != null) {
            return head.min;
        } else {
            return 0;
        }
    }

    public static class NodeWithMin {
        int val;
        int min;
        NodeWithMin next;

        public NodeWithMin(int val, int min, NodeWithMin next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Stack_155_MinStack minStack = new Stack_155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
    }

}
