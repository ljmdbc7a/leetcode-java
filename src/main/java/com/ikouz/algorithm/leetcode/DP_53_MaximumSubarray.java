package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which
 * is more subtle.
 */
public class DP_53_MaximumSubarray {

    /**
     * O(N)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int maxSub = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxSub + nums[i] < 0) {
                maxSub = 0;
                max = Math.max(nums[i], max);
            } else {
                maxSub = maxSub + nums[i];
                max = Math.max(maxSub, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(TestUtil.buildIntArr("[-2,1,-3,4,-1,2,1,-5,4]")));
        System.out.println(maxSubArray(TestUtil.buildIntArr("[-2]")));
        System.out.println(maxSubArray(TestUtil.buildIntArr("[1]")));
        System.out.println(maxSubArray(TestUtil.buildIntArr("[]")));
    }
}
