package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center). For example, this binary
 * tree [1,2,2,3,4,4,3] is symmetric:
 1
 / \
 2   2
 / \ / \
 3  4 4  3

 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 *
 * @author liujiaming
 * @since 2020/04/05
 *
 * 镜面树问题。
 *
 */
public class Tree_101_SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    private static boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricTree(left.right, right.left) && isSymmetricTree(left.left, right.right);
    }

    public static void main(String[] args) {
        TreeNode root = TestUtil.buildTree("[1,2,2,3,4,4,3]");
        TreeNode root1 = TestUtil.buildTree("[1,2,2,null,3,null,3]");
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric(root1));
    }

}
