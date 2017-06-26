package com.ikouz.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujiaming on 2016/07/16 22:23.
 */
public class Array_1_TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p/>
     * You may assume that each input would have exactly one solution.
     * <p/>
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p/>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // O(N)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) {
                return new int[]{i, map.get(diff)};
            }
        }
        return null;
    }
}
