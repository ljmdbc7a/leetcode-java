package com.ikouz.algorithm.leetcode;

/**
 * @author liujiaming
 * @since 2017/05/17
 */
public class String_387_FirstUniqueCharacterinaString {

    /**
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
     * <p>
     * Examples:
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     * <p>
     * Note: You may assume the string contain only lowercase letters.
     */

    public static int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        int[] hit = new int[26];
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            hit[ch - 'a']++;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (hit[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
