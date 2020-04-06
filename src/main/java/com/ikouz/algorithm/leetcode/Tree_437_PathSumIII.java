package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.The path does not need
 * to start or end at the root or a leaf, but it must go downwards (traveling
 * only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 *

 Example:
 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11

 *
 * @author liujiaming
 * @since 2020/04/05
 *
 * DFS and Recursive
 *
 */
public class Tree_437_PathSumIII {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum) {
            ret++;
        }
        ret += findPath(root.left, sum - root.val);
        ret += findPath(root.right, sum - root.val);
        return ret;
    }

    public static void main(String[] args) {
        // Test case 1
        TreeNode root = TestUtil.buildTree("[10,5,-3,3,2,null,11,3,-2,null,1]");
        System.out.println(pathSum(root, 8));

        // Test case 2
        TreeNode root1 = TestUtil.buildTree("[1,null,2,null,3,null,4,null,5]");
        System.out.println(pathSum(root1, 3));
    }

}
