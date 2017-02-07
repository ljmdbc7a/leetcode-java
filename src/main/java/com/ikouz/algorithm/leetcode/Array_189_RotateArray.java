package com.ikouz.algorithm.leetcode;

/**
 * Created by liujiaming on 2016/08/22 22:58.
 */
public class Array_189_RotateArray {

    /**
     * Rotate an array of n elements to the right by k steps.
     * <p/>
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * <p/>
     * Note:
     * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * <p/>
     * 总结：
     */
    public static void rotate(int[] nums, int k) {

    }

    public static void main(String args[]) {
        System.out.println("hello world!");
        int[] nums = {199, 200, 300, 400, 500, 600, 700};
        rotate2(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums.length <= k) {
            return;
        }
        int[] ret = new int[nums.length];
        System.arraycopy(nums, 0, ret, k, nums.length - k);
        System.arraycopy(nums, nums.length - k, ret, 0, k);
        System.arraycopy(ret, 0, nums, 0, nums.length);
    }
}
