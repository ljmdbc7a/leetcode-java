package com.ikouz.algorithm.basis;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * @author liujiaming
 * @since 2017/06/05
 */
public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] <= pivot) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] >= pivot) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[lo] = pivot;
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = TestUtil.buildIntArr("[1,5,9,4,3,7]");
        sort(arr);
        TestUtil.printIntArr(arr);
    }

}
