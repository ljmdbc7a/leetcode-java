package com.ikouz.algorithm.leetcode;

/**
 * Created by liujiaming on 2016/07/17 17:46.
 */
public class String_5_LongestPalindromicSubstring {

    /**
     * Given a string S, find the longest palindromic substring in S.
     * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
     * <p/>
     * 描述：求最长子回文串
     * 总结：方法1：双指针从中间向两边，注意考虑两种情况。
     * 方法2：二维数组，t[i,j]=1表示s[i] == s[j],空间换时间。(没弄明白遍历二维数组的逻辑)
     */
    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;
        int begin = 0, end = 0;
        for (int i = 0; i < len; i++) {
            // abcba情况
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < len) {
                if (arr[j] == arr[k]) {
                    if (end - begin < k - j) {// 更优结果
                        begin = j;
                        end = k;
                    }
                    j--;
                    k++;
                } else {
                    break;
                }
            }
            // abccba情况
            if (i + 1 < len && arr[i] == arr[i + 1]) {
                j = i - 1;
                k = i + 2;
                if (end - begin < 2) {// 更优结果
                    begin = i;
                    end = i + 1;
                }
                while (j >= 0 && k < len) {
                    if (arr[j] == arr[k]) {
                        if (end - begin < k - j) {// 更优结果
                            begin = j;
                            end = k;
                        }
                        j--;
                        k++;
                    } else {
                        break;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
