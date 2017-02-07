package com.ikouz.algorithm.leetcode;

/**
 * Created by liujiaming on 2017/02/07 11:54.
 */
public class Sort_242_ValidAnagram {

    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.
     * <p/>
     * For example,
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * <p/>
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * <p/>
     * Follow up:
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     * <p/>
     * 总结：使用值做数组下标。hash思想。
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s != null && t == null) || (s == null && t != null)) {
            return false;
        }

        int[] hashS = new int[26];
        int[] hashT = new int[26];
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        int index;
        for (int i = 0; i < arrS.length; i++) {
            index = arrS[i] - 'a';
            hashS[index]++;
        }
        for (int i = 0; i < arrT.length; i++) {
            index = arrT[i] - 'a';
            hashT[index]++;
        }

        for (int i = 0; i < hashS.length; i++) {
            if (hashS[i] != hashT[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aasdfa", "aasdfaa"));
    }
}
