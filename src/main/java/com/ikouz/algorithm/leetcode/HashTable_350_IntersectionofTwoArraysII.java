package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * <p>
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @author liujiaming
 * @since 2017/07/13
 */
public class HashTable_350_IntersectionofTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] arrLong = nums1.length > nums2.length ? nums1 : nums2;
        int[] arrShort = nums1.length > nums2.length ? nums2 : nums1;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(arrShort.length);
        for (int i : arrShort) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : arrLong) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ints = TestUtil.buildIntArr("[1,1,2,3,4]");
        int[] ints1 = TestUtil.buildIntArr("[1,2,5]");
        TestUtil.printIntArr(intersect(ints, ints1));
    }
}
