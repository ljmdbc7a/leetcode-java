package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * @author liujiaming
 * @since 2017/03/05
 */
public class Bit_137_SingleNumberII {

    /**
     * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
     * <p>
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * 总结：所有数的每一位出现0/1的次数是3+1，所以所求书
     */
    public static int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            ret |= ((sum % 3) << i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(TestUtil.buildIntArr("[1,1,1,3]")));
        System.out.println(singleNumber(TestUtil.buildIntArr("[-2,-2,1,1,-3,1,-3,-3,-4,-2]")));
    }
}
