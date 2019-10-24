package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray
 * of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Array_209_MinimumSizeSubarraySum {

    /**
     * Approach #1 Brute force
     * O(n^2)
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE, sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0; // Do not forget reset to 0
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                    }
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * Approach #2 Two pointers
     * O(n)
     */
    public static int minSubArrayLenII(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int from = 0;
        for (int to = 0; to < nums.length; to++) {
            sum += nums[to];
            while (sum >= s) {
                min = Math.min(min, to - from + 1);
                sum -= nums[from++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, TestUtil.buildIntArr("[2,3,1,2,4,3]")));
        System.out.println(minSubArrayLen(7, TestUtil.buildIntArr("[2,3,1,2,4,0,2]")));

        System.out.println(minSubArrayLenII(7, TestUtil.buildIntArr("[2,3,1,2,4,3]")));
        System.out.println(minSubArrayLenII(7, TestUtil.buildIntArr("[2,3,1,2,4,0,2]")));
    }
}
