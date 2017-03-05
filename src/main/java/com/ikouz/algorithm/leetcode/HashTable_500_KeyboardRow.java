package com.ikouz.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujiaming
 * @since 2017/02/23
 */
public class HashTable_500_KeyboardRow {

    /**
     * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
     * <p/>
     * Example 1:
     * Input: ["Hello", "Alaska", "Dad", "Peace"]
     * Output: ["Alaska", "Dad"]
     * <p/>
     * Note:
     * You may use one character in the keyboard more than once.
     * You may assume the input string will only contain letters of alphabet.
     */
    public static String[] findWords(String[] words) {
        if (words == null) {
            return null;
        }

        Map<Character, Integer> keyMap = new HashMap<Character, Integer>(26) {{
            put('q', 1);
            put('w', 1);
            put('e', 1);
            put('r', 1);
            put('t', 1);
            put('y', 1);
            put('u', 1);
            put('i', 1);
            put('o', 1);
            put('p', 1);
            put('Q', 1);
            put('W', 1);
            put('E', 1);
            put('R', 1);
            put('T', 1);
            put('Y', 1);
            put('U', 1);
            put('I', 1);
            put('O', 1);
            put('P', 1);
            put('a', 2);
            put('s', 2);
            put('d', 2);
            put('f', 2);
            put('g', 2);
            put('h', 2);
            put('j', 2);
            put('k', 2);
            put('l', 2);
            put('A', 2);
            put('S', 2);
            put('D', 2);
            put('F', 2);
            put('G', 2);
            put('H', 2);
            put('J', 2);
            put('K', 2);
            put('L', 2);
            put('z', 3);
            put('x', 3);
            put('c', 3);
            put('v', 3);
            put('b', 3);
            put('n', 3);
            put('m', 3);
            put('Z', 3);
            put('X', 3);
            put('C', 3);
            put('V', 3);
            put('B', 3);
            put('N', 3);
            put('M', 3);
        }};

        List<String> list = new ArrayList<String>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            if (chars.length < 2) {
                list.add(word);
            } else {
                boolean b = true;
                for (int i = 1; i < chars.length; i++) {
                    if (keyMap.get(chars[0]) != keyMap.get(chars[i])) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    list.add(word);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String[] arr = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
