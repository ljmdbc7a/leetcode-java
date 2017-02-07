package com.ikouz.study;

import com.ikouz.study.utils.TestUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liujiaming on 2017/02/07 14:57.
 */
public class Sort_349_IntersectionofTwoArrays {

    /**
     * Given two arrays, write a function to compute their intersection.
     * <p/>
     * Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     * <p/>
     * Note:
     * Each element in the result must be unique.
     * The result can be in any order.
     * <p/>
     * 总结:
     * 思路1： 排序+双指针
     * 思路2： hashSet
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] ret = new int[set2.size()];
        Object[] arr = set2.toArray();
        for (int i = 0; i < arr.length; i++) {
            ret[i] = (Integer) arr[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        TestUtil.printIntArr(intersection(TestUtil.buildIntArr("[1,1]"), TestUtil.buildIntArr("[1,3,7,1,2,1]")));
    }

}
