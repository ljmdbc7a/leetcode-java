package com.ikouz.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 *
 * @author liujiaming
 * @since 2020/04/06
 *
 */
public class Stack_20_ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>(3);
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character c : chars) {
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (c.equals(charMap.get(peek))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([}]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[]}"));
    }

}
