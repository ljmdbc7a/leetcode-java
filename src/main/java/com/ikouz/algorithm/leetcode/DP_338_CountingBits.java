package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time
 * O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other
 * language.
 */
public class DP_338_CountingBits {

    /**
     * O(n*m) m=max bit number of num
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] countArr = new int[num + 1];
        for (int i = 1; i <= num; i <<= 1) {
            for (int j = 0; j < num + 1; j++) {
                countArr[j] += (j & i) == 0 ? 0 : 1;
            }
        }
        return countArr;
    }

    public static void main(String[] args) {
        TestUtil.printIntArr(countBits(2));
        TestUtil.printIntArr(countBits(5));
    }
}
