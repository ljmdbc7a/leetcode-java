package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author liujiaming
 * @since 2017/06/26
 */
public class Array_283_MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            j = i;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (i < nums.length && j < nums.length) {
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] intArr = TestUtil.buildIntArr("[0,1,0,3,12]");
        int[] intArr = TestUtil.buildIntArr("[1,0]");
        moveZeroes(intArr);
        TestUtil.printIntArr(intArr);
    }
}
