package com.ikouz.algorithm.leetcode;

import java.util.Stack;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * @author liujiaming
 * @since 2017/05/19
 */
public class String_557_ReverseWordsinaStringIII {

    public static String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') {
                while (!characterStack.isEmpty()) {
                    sb.append(characterStack.pop());
                }
                sb.append(ch);
            } else {
                characterStack.push(ch);
            }
        }
        while (!characterStack.isEmpty()) {
            sb.append(characterStack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
