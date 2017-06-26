package com.ikouz.algorithm.basis;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2017/02/14 14:25.
 */
public class SelectionSort {

    /**
     * 选择排序
     */
    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = TestUtil.buildIntArr("[1,4,6,0,9,2]");
        TestUtil.printIntArr(sort(arr));
    }


}
