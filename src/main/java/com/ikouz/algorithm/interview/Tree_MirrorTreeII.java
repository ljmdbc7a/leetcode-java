package com.ikouz.algorithm.interview;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Judge a tree Symmetrical
 */
public class Tree_MirrorTreeII {

    public static Boolean isSymmetricalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private static Boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetricalTree(TestUtil.buildTree("[1,2,2,3,4,4,3]")));
    }
}
