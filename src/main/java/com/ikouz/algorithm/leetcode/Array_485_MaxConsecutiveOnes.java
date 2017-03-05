package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class Array_485_MaxConsecutiveOnes {

    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     * <p>
     * Example 1:
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     * Note:
     * <p>
     * The input array will only contain 0 and 1.
     * The length of input array is a positive integer and will not exceed 10,000
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = 0, tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp++;
            } else {
                if (tmp > max) {
                    max = tmp;
                }
                tmp = 0;
            }
        }
        return tmp > max ? tmp : max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(TestUtil.buildIntArr("[1,1,0,1,1,1]")));
    }
}
