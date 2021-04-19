package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an array of integers nums.
 * <p>
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Return the number of good pairs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Array_1512_NumberofGoodPairs {

    public static int numIdenticalPairs(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public static int numIdenticalPairsI(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int ret = 0;
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            ret += count[i] * (count[i] - 1) / 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairsI(TestUtil.buildIntArr("[1,2,3,1,1,3]")));
    }
}
