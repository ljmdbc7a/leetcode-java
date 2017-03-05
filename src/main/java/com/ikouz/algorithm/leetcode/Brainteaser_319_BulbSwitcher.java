package com.ikouz.algorithm.leetcode;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class Brainteaser_319_BulbSwitcher {

    /**
     * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
     * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
     * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
     * Find how many bulbs are on after n rounds.
     * <p>
     * Example:
     * Given n = 3.
     * At first, the three bulbs are [off, off, off].
     * After first round, the three bulbs are [on, on, on].
     * After second round, the three bulbs are [on, off, on].
     * After third round, the three bulbs are [on, off, off].
     * <p>
     * So you should return 1, because there is only one bulb is on.
     * <p>
     * 总结：1 4 9 16... 可开方数的因子数为奇数，其他数的因子数为偶数。
     */
    public static int bulbSwitch(int n) {
        if (n <= 0) {
            return 0;
        }
        return (int) Math.sqrt(n);
    }
}
