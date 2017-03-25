package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujiaming
 * @since 2017/03/05
 */
public class Array_448_FindAllNumbersDisappearedinanArray {

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     * <p>
     * Example:
     * Input:
     * [4,3,2,7,8,2,3,1]
     * Output:
     * [5,6]
     * <p>
     * 总结：
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int tmp, index;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i] - 1;
            while (nums[index] != index + 1) {
                tmp = nums[index];
                nums[index] = index + 1;
                index = tmp - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(TestUtil.buildIntArr("[4,3,2,7,8,2,3,1]")));
    }
}
