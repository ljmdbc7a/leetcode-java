package com.ikouz.algorithm.leetcode;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * <p>
 * 总结：移位+位运算
 *
 * @author liujiaming
 * @since 2017/06/07
 */
public class Bit_191_Numberof1Bits {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE > 2147483648L);
        System.out.println(hammingWeight(11));
    }
}
