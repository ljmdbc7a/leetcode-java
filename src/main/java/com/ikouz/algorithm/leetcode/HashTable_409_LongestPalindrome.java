package com.ikouz.algorithm.leetcode;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * @author liujiaming
 * @since 2017/05/17
 */
public class HashTable_409_LongestPalindrome {

    public static int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] flag = new int['z' - 'A' + 1];
        for (int i = 0; i < chars.length; i++) {
            flag[chars[i] - 'A']++;
        }
        int count = 0, m = 0;
        for (int i = 0; i < flag.length; i++) {
            count += (flag[i] / 2 * 2);
            m |= flag[i] % 2;
        }
        return count + m;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("aa"));
    }
}
