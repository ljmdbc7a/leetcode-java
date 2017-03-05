package com.ikouz.algorithm.leetcode;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class String_520_DetectCapital {

    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.
     * <p>
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital if it has more than one letter, like "Google".
     * Otherwise, we define that this word doesn't use capitals in a right way.
     * <p>
     * Example 1:
     * Input: "USA"
     * Output: True
     * Example 2:
     * Input: "FlaG"
     * Output: False
     * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
     */
    public static boolean detectCapitalUse(String word) {
        if (word == null) {
            return false;
        }

        char[] chars = word.toCharArray();
        if (Character.isUpperCase(chars[0])) {
            if (chars.length > 1) {
                if (Character.isUpperCase(chars[1])) {
                    for (int i = 2; i < chars.length; i++) {
                        if (!Character.isUpperCase(chars[i])) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 2; i < chars.length; i++) {
                        if (Character.isUpperCase(chars[i])) {
                            return false;
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Ua"));
    }
}
