package com.ikouz.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class Normal_412_FizzBuzz {

    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     * <p>
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
     * For numbers which are multiples of both three and five output “FizzBuzz”.
     */
    public static List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ret.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ret.add("Fizz");
            } else if (i % 5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

}
