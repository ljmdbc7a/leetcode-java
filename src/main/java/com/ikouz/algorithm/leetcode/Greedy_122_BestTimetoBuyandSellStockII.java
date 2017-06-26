package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * @author liujiaming
 * @since 2017/06/26
 */
public class Greedy_122_BestTimetoBuyandSellStockII {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int low = prices[0];
        int high = low;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                maxProfit += high - low;
                low = prices[i];
                high = low;
            } else {
                high = prices[i];
            }
        }
        maxProfit += high - low;
        return maxProfit;
    }

    // Is this question a joke?
    public static int maxProfit2(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit2(TestUtil.buildIntArr("[1,3,9,2]")));
    }
}
