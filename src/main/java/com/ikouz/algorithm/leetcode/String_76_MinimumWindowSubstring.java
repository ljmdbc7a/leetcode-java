package com.ikouz.algorithm.leetcode;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * <p>
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class String_76_MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }

        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        int[] hit = new int[128];
        int[] target = new int[128];
        for (int i = 0; i < 128; i++) {
            hit[i] = -1;
        }
        for (char c : tArr) {
            hit[c] = 0;
            target[c]++;
        }

        int from = 0;
        String ret = "";
        int win = Integer.MAX_VALUE;
        for (int to = 0; to < sArr.length; to++) {
            if (hit[sArr[to]] != -1) {
                hit[sArr[to]]++;
            }
            while (containsAll(tArr, hit, target)) {
                if (to - from + 1 < win) {
                    win = to - from + 1;
                    ret = s.substring(from, to + 1);
                }
                if (hit[sArr[from]] != -1) {
                    hit[sArr[from]]--;
                }
                from++;
            }
        }
        return ret;
    }

    private static boolean containsAll(char[] tArr, int[] hit, int[] target) {
        for (char c : tArr) {
            if (hit[c] < target[c]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("aa", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
