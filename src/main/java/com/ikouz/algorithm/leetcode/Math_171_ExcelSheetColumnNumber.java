package com.ikouz.algorithm.leetcode;

/**
 * Related to question Excel Sheet Column Title
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * @author liujiaming
 * @since 2017/06/26
 */
public class Math_171_ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        int sum = 0, carry = 1;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += (arr[i] - 'A' + 1) * carry;
            carry *= 26;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }
}