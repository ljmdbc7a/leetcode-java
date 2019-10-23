package com.ikouz.algorithm.leetcode;

public class DP_1025_DivisorGame {

    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     * <p>
     * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
     * <p>
     * Choosing any x with 0 < x < N and N % x == 0.
     * Replacing the number N on the chalkboard with N - x.
     * Also, if a player cannot make a move, they lose the game.
     * <p>
     * Return True if and only if Alice wins the game, assuming both players play optimally.
     * <p>
     * <p>
     * Example 1:
     * Input: 2
     * Output: true
     * Explanation: Alice chooses 1, and Bob has no more moves.
     * <p>
     * Example 2:
     * Input: 3
     * Output: false
     * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
     * <p>
     * <p>
     * Note:
     * 1 <= N <= 1000
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
