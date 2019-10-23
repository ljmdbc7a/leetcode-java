package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Array_59_SpiralMatrixII {

    public static int[][] buildSpiralMatrix(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] spiralMatrix = new int[n][n];
        int content = 1;
        int left = 0, right = n - 1, top = 0, down = n - 1;
        while (left <= right || top <= down) {
            for (int j = left; j <= right; j++) {
                spiralMatrix[top][j] = content++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                spiralMatrix[i][right] = content++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                spiralMatrix[down][j] = content++;
            }
            down--;
            for (int i = down; i >= top; i--) {
                spiralMatrix[i][left] = content++;
            }
            left++;
        }
        return spiralMatrix;
    }

    public static void main(String[] args) {
        TestUtil.printIntArrArr(buildSpiralMatrix(4));
    }
}
