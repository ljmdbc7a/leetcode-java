package com.ikouz.algorithm.interview;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Super Mario can jump one or two steps per time. Once Mario jumps, he can earn or lost X coins.
 * <p>
 * Example 1:
 * Input: coins = [1, 5, -2, -10, 20]
 * Output: 24
 * Explanation: 1 5 -2 20.
 */
public class DP_MaxCoinsCollection {

    /**
     * dp[i] = Math.max(dp[i-1], dp[i-2]) + coins[i];
     *
     * @param coins
     * @return
     */
    public static int maxCoins(int[] coins) {
        if (coins == null) {
            return 0;
        }
        if (coins.length == 1) {
            return Math.max(coins[0], 0);
        }
        int[] dp = new int[coins.length];
        dp[0] = coins[0];
        dp[1] = Math.max(dp[0], 0) + coins[1];
        for (int i = 2; i < coins.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2]) + coins[i];
        }
        return Math.max(dp[coins.length - 2], dp[coins.length - 1]);
    }

    public static int maxValue(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return Math.max(array[0], 0);
        }
        int pre = 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            int tmp = max;
            max = Math.max(max + array[i], pre + array[i]);
            pre = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(TestUtil.buildIntArr("[1, 5, -2, -10, -20, 20]")));
        System.out.println(maxValue(TestUtil.buildIntArr("[1, 5, -2, -10, -20, 20]")));
    }
}
