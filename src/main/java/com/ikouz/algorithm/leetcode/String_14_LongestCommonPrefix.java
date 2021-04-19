package com.ikouz.algorithm.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class String_14_LongestCommonPrefix {

    /**
     * 找出所有字符串的最长公共前缀。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String shortestStr = strs[0];
        int strLen = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strLen > strs[i].length()) {
                strLen = strs[i].length();
                shortestStr = strs[i];
            }
        }

        String longestCommonPrefix = "";
        String prefix;
        for (int i = 0; i < shortestStr.length(); i++) {
            prefix = shortestStr.substring(0, i + 1);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix = prefix;
        }
        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"aaaa"}));
    }
}
