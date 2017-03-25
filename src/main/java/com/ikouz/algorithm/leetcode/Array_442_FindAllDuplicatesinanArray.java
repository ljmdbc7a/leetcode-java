package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujiaming
 * @since 2017/03/25
 */
public class Array_442_FindAllDuplicatesinanArray {

    /**
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * <p>
     * Find all the elements that appear twice in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime?
     * <p>
     * Example:
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [2,3]
     * <p>
     * 总结：当前数字做数组下表，讲下标位置的数字取负值，如果发现已经取了负值，则说明已经出现过一次。
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(TestUtil.buildIntArr("[4,3,2,7,8,2,3,1]")));
    }
}
