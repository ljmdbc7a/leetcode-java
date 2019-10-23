package com.ikouz.algorithm.leetcode;

/**
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 * <p>
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 * <p>
 * <p>
 * <p>
 * Note:
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class DP_931_MinimumFallingPathSum {

    /**
     * @param A
     * @return
     */
    public static int minFallingPathSum(int[][] A) {
        return 0;
    }
}
