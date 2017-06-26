package com.ikouz.algorithm.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * 总结：考虑二进制特点。2，4，8，16，，，最高位为1，后面都是0
 *
 * @author liujiaming
 * @since 2017/06/07
 */
public class Bit_231_PowerofTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 ? (n & (n - 1)) == 0 : false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }
}
