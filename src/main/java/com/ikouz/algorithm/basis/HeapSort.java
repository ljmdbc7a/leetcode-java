package com.ikouz.algorithm.basis;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2017/02/07 16:44.
 */
public class HeapSort {

    /**
     * 堆排序
     */
    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }

        // build heap
        int len = arr.length;
        buildHeap(arr, len);

        // sort
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    /**
     * 构造初始堆:
     * 从最后一个非叶节点开始调整，直到根节点
     */
    private static void buildHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }

    /**
     * 调整堆的第i个节点
     * 1. 从父节点、左孩子节点、右孩子节点三者中选择最大者跟父节点进行交换
     * 2. 发生交换之后要重新对被交换的孩子节点进行调整。
     *
     * @param arr
     * @param i
     * @param len
     */
    private static void adjustHeap(int[] arr, int i, int len) {
        int lchild = 2 * i + 1;
        int rchild = 2 * i + 2;
        int max = i;
        int maxV = arr[i];

        if (lchild >= len) {
            // i为叶子节点，不做调整
            return;
        }

        if (lchild < len && arr[lchild] > maxV) {
            max = lchild;
            maxV = arr[lchild];
        }
        if (rchild < len && arr[rchild] > maxV) {
            max = rchild;
            maxV = arr[rchild];
        }
        if (max != i) {
            swap(arr, i, max);
            adjustHeap(arr, max, len);
        }

    }

    private static void swap(int[] arr, int i, int max) {
        int tmp = arr[i];
        arr[i] = arr[max];
        arr[max] = tmp;
    }

    public static void main(String[] args) {
        TestUtil.printIntArr(sort(TestUtil.buildIntArr("[1,9,5,82,2]")));
    }

}
