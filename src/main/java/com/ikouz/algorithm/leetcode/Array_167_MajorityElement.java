package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author liujiaming
 * @since 2017/05/17
 */
public class Array_167_MajorityElement {

    public static int majorityElement(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }

        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                if (count <= 0) {
                    major = nums[i];
                } else {
                    count--;
                }
            }
        }
        return major;
    }

    public static int majorityElement_stack(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (p < 0 || nums[p] == nums[i]) {
                nums[++p] = nums[i];
            } else {
                p--;
            }
        }
        return nums[p];
    }

    public static void main(String[] args) {
        int[] ints = TestUtil.buildIntArr("[1,1,3,3,4,4,4,4,4]");
        System.out.println(majorityElement(ints));
    }
}
