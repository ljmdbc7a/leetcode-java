package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class DP_198_HouseRobber {

    /**
     * dp[i] = Max(dp[i-1], dp[i-2]+nums[i])
     * O(N) space
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    /**
     * dp[i] = Max(dp[i-1], dp[i-2]+nums[i])
     * O(1) space
     *
     * @param nums
     * @return
     */
    public static int robII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dpi_2 = nums[0], dpi_1 = Math.max(nums[0], nums[1]);
        int dpi = 0;
        for (int i = 2; i < nums.length; i++) {
            dpi = Math.max(dpi_1, dpi_2 + nums[i]);
            dpi_2 = dpi_1;
            dpi_1 = dpi;
        }
        return dpi;
    }

    public static void main(String[] args) {
        System.out.println(rob(TestUtil.buildIntArr("[2,7,9,3,1]")));
        System.out.println(rob(TestUtil.buildIntArr("[2, 1, 1, 2]")));

        System.out.println(robII(TestUtil.buildIntArr("[2,7,9,3,1]")));
        System.out.println(robII(TestUtil.buildIntArr("[2, 1, 1, 2]")));
    }

}
