package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class Bit_136_SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * 总结：A ^ A = 0
     */
    public static int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(TestUtil.buildIntArr("[1,2,3,4,4,3,2]")));
    }
}
