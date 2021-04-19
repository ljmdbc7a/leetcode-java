package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * <p>
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 * Example 3:
 * <p>
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
public class Array_1470_ShuffletheArray {

    public static int[] shuffle(int[] nums, int n) {
        if (nums == null || n * 2 != nums.length) {
            return null;
        }
        int[] ret = new int[nums.length];
        int p = 0, q = n;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                ret[i] = nums[p++];
            } else {
                ret[i] = nums[q++];
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] arr = TestUtil.buildIntArr("[2,5,1,3,4,7]");
        TestUtil.printIntArr(shuffle(arr, 3));
    }

}
