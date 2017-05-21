package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * 总结：任意节点的最大距离。如果最大距离路径过根节点，则等于（左子树深度+右子树深度），如果不过根节点，则在左子树或者右子树。
 *
 * @author liujiaming
 * @since 2017/05/20
 */
public class Tree_543_DiameterofBinaryTree {

    static int max;

    public static int diameterOfBinaryTree(TreeNode root) {
        max(root);
        return max;
    }

    private static int max(TreeNode root) {
        if (root == null) {
            max = 0;
            return 0;
        }
        int len = deep(root.left) + deep(root.right); // 过根节点
        int maxl = max(root.left);
        int maxr = max(root.right);
        max = Math.max(len, Math.max(maxl, maxr));
        return max;
    }

    private static int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(TestUtil.buildTree("[1,2,3,4,5]")));
    }

}
