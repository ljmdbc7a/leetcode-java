package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * @author liujiaming
 * @since 2017/03/25
 * <p>
 * 总结：计算二叉树深度，递归思想，max(maxDepth(left), maxDepth(right)) + 1
 */
public class Tree_104_MaximumDepthofBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TestUtil.buildTree("[1,2,3,null,null,4,null,null,5]");
        TestUtil.printTree(treeNode);
        System.out.println(maxDepth(TestUtil.buildTree("[1,2,3,null,null,4,null,null,5]")));
    }
}
