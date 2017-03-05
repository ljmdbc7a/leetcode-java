package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class Stack_496_NextGreaterElementI {

    /**
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
     * <p>
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
     * <p>
     * Example 1:
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * Output: [-1,3,-1]
     * Explanation:
     * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
     * For number 1 in the first array, the next greater number for it in the second array is 3.
     * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
     * Example 2:
     * Input: nums1 = [2,4], nums2 = [1,2,3,4].
     * Output: [3,-1]
     * Explanation:
     * For number 2 in the first array, the next greater number for it in the second array is 3.
     * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
     * <p>
     * Note:
     * All elements in nums1 and nums2 are unique.
     * The length of both nums1 and nums2 would not exceed 1000.
     * <p>
     * 总结：当后续计算需要依赖前置数据时，前置数据可以考虑使用stack存储。
     */
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null || nums == null) {
            return null;
        }

        int[] ret = new int[findNums.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = -1;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.empty() == false && stack.peek() < nums[i]) {
                for (int j = 0; j < findNums.length; j++) {
                    if (findNums[j] == stack.peek()) {
                        ret[j] = nums[i];
                        break;
                    }
                }
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return ret;
    }

    /**
     * 用map存储结果，换时间
     */
    public static int[] nextGreaterElement2(int[] findNums, int[] nums) {
        if (findNums == null || nums == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(findNums.length);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.empty() == false && stack.peek() < nums[i]) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }

        int[] ret = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            ret[i] = map.get(findNums[i]) == null ? -1 : map.get(findNums[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        TestUtil.printIntArr(nextGreaterElement(TestUtil.buildIntArr("[4,1,2]"), TestUtil.buildIntArr("[1,3,4,2]")));
        TestUtil.printIntArr(nextGreaterElement2(TestUtil.buildIntArr("[4,1,2]"), TestUtil.buildIntArr("[1,3,4,2]")));
    }
}
