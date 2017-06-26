package com.ikouz.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * @author liujiaming
 * @since 2017/06/10
 */
public class Array_217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
