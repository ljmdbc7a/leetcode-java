package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Math_121_BestTimetoBuyandSellStock {

    /**
     * O(N^2)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = prices[j] - prices[i] > maxProfit ? prices[j] - prices[i] : maxProfit;
            }
        }
        return maxProfit;
    }

    /**
     * O(N)
     *
     * @param prices
     * @return
     */
    public static int maxProfitII(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(TestUtil.buildIntArr("[7,1,5,3,6,4]")));
        System.out.println(maxProfitII(TestUtil.buildIntArr("[7,1,5,3,6,4]")));
        System.out.println(maxProfitII(TestUtil.buildIntArr("[7,6,4,3,1]")));
    }
}
