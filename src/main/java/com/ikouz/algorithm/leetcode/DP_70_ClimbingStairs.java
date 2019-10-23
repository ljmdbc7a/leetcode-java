package com.ikouz.algorithm.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class DP_70_ClimbingStairs {

    /**
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] stepCount = new int[n + 1];
        stepCount[1] = 1;
        stepCount[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            stepCount[i] = stepCount[i - 1] + stepCount[i - 2];
        }
        return stepCount[n];
    }

    /**
     * Recursion Solution. Caused Time Limit Exceeded. Can be optimized with memory cache.
     *
     * @param n
     * @return
     */
    public static int climbStairsII(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairsII(n - 1) + climbStairsII(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairsII(3));
    }
}
