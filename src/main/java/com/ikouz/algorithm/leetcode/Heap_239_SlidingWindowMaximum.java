package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class Heap_239_SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] ret = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            ret[j++] = queue.peek();
            queue.offer(nums[i]);
            queue.remove(nums[i - k]);
        }
        ret[j++] = queue.peek();
        return ret;
    }

    public static void main(String[] args) {
        TestUtil.printIntArr(maxSlidingWindow(TestUtil.buildIntArr("[]"), 0));
        TestUtil.printIntArr(maxSlidingWindow(TestUtil.buildIntArr("[1,3,-1,-3,5,3,6,7]"), 3));
    }
}
