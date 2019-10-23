package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Array_54_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> ret = new ArrayList();
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                ret.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                ret.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && top <= down; i--) {
                ret.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= top && left <= right; i--) {
                ret.add(matrix[i][left]);
            }
            left++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(TestUtil.buildIntArrArr("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")));
    }

}
