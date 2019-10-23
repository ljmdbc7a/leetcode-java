package com.ikouz.algorithm.interview;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * If a binary tree is mirror.
 */
public class Tree_MirrorTree {

    public static Boolean isMirrorTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null && root.left.val == root.right.val) {
            return isMirrorTree(root.left) && isMirrorTree(root.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMirrorTree(TestUtil.buildTree("[1,2,2,3,4,4,3]")));
    }
}
