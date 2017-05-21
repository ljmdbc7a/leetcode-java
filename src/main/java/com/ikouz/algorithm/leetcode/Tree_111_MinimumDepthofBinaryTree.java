package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * 总结：Math.min（左子树最小深度，右子树最小深度）+ 1
 * 如果节点左右子树都为空，返回0；左子树为空，递归右子树+1；右子树为空，递归左子树+1；
 *
 * @author liujiaming
 * @since 2017/05/21
 */
public class Tree_111_MinimumDepthofBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minDepth(TestUtil.buildTree("[1,2,3,4]")));
    }
}
