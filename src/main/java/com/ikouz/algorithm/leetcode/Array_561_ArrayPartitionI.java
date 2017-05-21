package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4.
 * <p>
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * <p>
 * 总结：有O(n)的做法，利用桶排序的思想，申请20000大小是桶，遍历一遍放到数组中，然后遍历一遍取奇数位置求和。
 *
 * @author liujiaming
 * @since 2017/05/19
 */
public class Array_561_ArrayPartitionI {

    /**
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(TestUtil.buildIntArr("[1,3,4,2]")));
    }
}
