package com.ikouz.algorithm.leetcode;

/**
 * Created by liujiaming on 2016/07/20 22:04.
 */
public class Math_8_StringtoInteger {
    /**
     * Implement atoi to convert a string to an integer.
     * <p/>
     * Hint: Carefully consider all possible input cases.
     * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
     * <p/>
     * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
     * You are responsible to gather all the input requirements up front.
     * <p/>
     * 描述：case: "2147483648" -> 2147483647
     * 总结：注意超过边界值，返回边界值
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.trim().toCharArray();
        int i = 0;
        long ret = 0;
        boolean b = false;
        if (arr[0] == '-') {
            i = 1;
            b = true;
        } else if (arr[0] == '+') {
            i = 1;
        }
        for (; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                ret = ret * 10 + (arr[i] - '0');
                if (b == true && -ret < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (b == false && ret > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                return b == true ? (int) -ret : (int) ret;
            }
        }

        return b == true ? (int) -ret : (int) ret;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+49 23"));
        System.out.println(myAtoi("-3322934234823"));
    }
}
