package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.domain.TreeNode;
import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author liujiaming
 * @since 2017/07/14
 */
public class Tree_108_ConvertSortedArraytoBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int pivot = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[pivot]);
        treeNode.left = buildBST(nums, start, pivot - 1);
        treeNode.right = buildBST(nums, pivot + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] intArr = TestUtil.buildIntArr("[1,2,3,4,5]");
        TestUtil.printTree(sortedArrayToBST(intArr));
    }
}
