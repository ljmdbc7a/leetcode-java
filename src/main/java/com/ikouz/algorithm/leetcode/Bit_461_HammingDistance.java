package com.ikouz.algorithm.leetcode;

/**
 * @author liujiaming
 * @since 2017/02/23
 */
public class Bit_461_HammingDistance {

    /**
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * <p/>
     * Note:
     * 0 ≤ x, y < 231.
     * <p/>
     * Example:
     * Input: x = 1, y = 4
     * Output: 2
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * -------↑   ↑
     * The above arrows point to positions where the corresponding bits are different.
     * <p/>
     * 总结：一个int，按位表示，统计1|0的个数
     */
    public static int hammingDistance(int x, int y) {
        int m = x ^ y;
        int ret = 0;
        while (m > 0) {
            if ((m & 1) == 1) {
                ret++;
            }
            m = m >>> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 1));
    }
}
