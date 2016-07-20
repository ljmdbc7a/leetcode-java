package com.ikouz.study;

/**
 * Created by liujiaming on 2016/07/20 22:58.
 */
public class Math_9_PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     * <p/>
     * 总结：注意去掉首末位循环时，i = i - 2;
     */
    public static boolean isPalindrome(int x) {
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
        System.out.println(isPalindrome(1000021));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-2147447412));
    }
}
