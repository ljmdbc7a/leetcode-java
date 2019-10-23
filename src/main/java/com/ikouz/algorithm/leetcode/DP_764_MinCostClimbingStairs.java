package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class DP_764_MinCostClimbingStairs {

    /**
     * dp[i] = min(dp[i-1], dp[i-2]) + cost[i-1]
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = cost[0];
        minCost[2] = cost[1];
        for (int i = 3; i < minCost.length; i++) {
            minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i - 1];
        }
        return Math.min(minCost[minCost.length - 1], minCost[minCost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(TestUtil.buildIntArr("[10, 15, 20]")));
        System.out.println(minCostClimbingStairs(TestUtil.buildIntArr("[1, 100, 1, 1, 1, 100, 1, 1, 100, 1]")));
    }
}
