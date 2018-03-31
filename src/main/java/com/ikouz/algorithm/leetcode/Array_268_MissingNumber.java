package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @author liujiaming
 * @since 2017/07/14
 */
public class Array_268_MissingNumber {

    public static int missingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int n = nums.length;
        int prefectSum = (n * n + n) / 2;
        return prefectSum - sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(TestUtil.buildIntArr("[6]")));
    }

}
