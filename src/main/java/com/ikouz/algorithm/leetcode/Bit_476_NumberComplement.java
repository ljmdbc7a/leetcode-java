package com.ikouz.algorithm.leetcode;

/**
 * @author liujiaming
 * @since 2017/02/23
 */
public class Bit_476_NumberComplement {

    /**
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
     * <p/>
     * Note:
     * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
     * You could assume no leading zero bit in the integer’s binary representation.
     * <p/>
     * Example 1:
     * Input: 5
     * Output: 2
     * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
     * Example 2:
     * Input: 1
     * Output: 0
     * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
     * <p/>
     * 总结：按位取反
     */
    public static int findComplement(int num) {
        int ret = 0, step = 1;
        while (num > 0) {
            if ((num & 1) == 0) {
                ret += step;
            }
            step *= 2;
            num = num >>> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
