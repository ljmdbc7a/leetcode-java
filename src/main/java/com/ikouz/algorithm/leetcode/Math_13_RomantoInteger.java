package com.ikouz.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead,
 * the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to
 * the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class Math_13_RomantoInteger {

    /**
     * return integer
     *
     * @param s Roman numerals
     * @return
     */
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<String, Integer> romanNumMap = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("IV", 4);
                put("IX", 9);
                put("XL", 40);
                put("XC", 90);
                put("CD", 400);
                put("CM", 900);
            }
        };

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() > i + 1 && romanNumMap.containsKey(s.substring(i, i + 2))) {
                result += romanNumMap.get(s.substring(i, i + 2));
                i++;
            } else {
                result += romanNumMap.get(s.substring(i, i + 1));
            }
        }
        return result;
    }

    /**
     * 每个字符加上去，如果下一个比上一个大，则要减去上一个
     */
    public static int romanToIntII(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> romanNumMap = new HashMap<Character, Integer>() {
            {
                put('M', 1000);
                put('D', 500);
                put('C', 100);
                put('L', 50);
                put('X', 10);
                put('V', 5);
                put('I', 1);
            }
        };

        char[] chars = s.toCharArray();
        int prev = romanNumMap.get(chars[0]);
        int sum = 0;
        int next;
        for (int i = 1; i < chars.length; i++) {
            next = romanNumMap.get(chars[i]);
            if (prev < next) {
                sum -= prev;
            } else {
                sum += prev;
            }
            prev = next;
        }
        sum += prev;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

        System.out.println(romanToIntII("III"));
        System.out.println(romanToIntII("IV"));
        System.out.println(romanToIntII("LVIII"));
        System.out.println(romanToIntII("MCMXCIV"));
    }
}
