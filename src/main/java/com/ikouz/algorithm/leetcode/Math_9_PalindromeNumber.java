package com.ikouz.algorithm.leetcode;

/**
 * Created by liujiaming on 2016/07/20 22:58.
 */
public class Math_9_PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     * <p/>
     * 总结：反正后是否相等
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int y = 0, tmp = x;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp /= 10;
        }
        return y == x;
    }

    /**
     * 总结：去掉首末位的方式行不通，解决不了 1021 这种去掉首末后丢掉0的情况
     */
    @Deprecated public static boolean isPalindrome_1(int x) {
        if (x < 0) {
            return false;
        }
        int i = -1, tmp = x, a, b, k;
        while (tmp != 0) { // 获取位数
            tmp = tmp / (10);
            i++;
        }
        tmp = x;
        while (tmp < -9 || tmp > 9) {
            a = tmp % 10;
            k = (int) Math.pow(10.0, (double) i);
            b = tmp / k;
            if (a != b) {
                return false;
            }
            i -= 2;
            tmp = (tmp - b * k) / 10; // 去掉首末位
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10021));
        System.out.println(isPalindrome(1119123219));
        System.out.println(isPalindrome(-2147447412));
    }
}
