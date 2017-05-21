package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @author liujiaming
 * @since 2017/05/21
 */
public class Tree_404_SumofLeftLeaves {

    public static int sumOfLeftLeaves(TreeNode root) {
        return doSumOfLeftLeaves(root, false);
    }

    private static int doSumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }
        return doSumOfLeftLeaves(root.left, true) + doSumOfLeftLeaves(root.right, false);
    }

    public static void main(String[] args) {
        System.out.println(sumOfLeftLeaves(TestUtil.buildTree("[3,9,20,null,null,15,7]")));
    }
}
