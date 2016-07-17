package com.ikouz.study;

/**
 * Created by liujiaming on 2016/07/17 00:23.
 */
public class String_3_LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p/>
     * Examples:
     * <p/>
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * <p/>
     * Given "bbbbb", the answer is "b", with the length of 1.
     * <p/>
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * <p/>
     * 总结:双指针
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        int i = 0, j = 0, max = 1;
        while (i < len && j < len) {
            for (j = i + 1; j < len; ) {
                boolean found = false;
                int k = i;
                for (; k < j; k++) {
                    if (arr[k] == arr[j]) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    max = Math.max(max, j - i);
                    i = k + 1;
                    break;
                } else {
                    j++;
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
