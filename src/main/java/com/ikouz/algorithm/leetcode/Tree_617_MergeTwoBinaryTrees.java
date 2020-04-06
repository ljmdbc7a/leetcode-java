package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 *
 * @author liujiaming
 * @since 2018/03/31
 *
 * 递归和非递归两种解法。
 */
public class Tree_617_MergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = TestUtil.buildTree("[1, 3, 2, 5]");
        TreeNode t2 = TestUtil.buildTree("[2, 1, 3, null, null, 4, 7]");
        TestUtil.printTree(mergeTrees(t1, t2));
    }

}
