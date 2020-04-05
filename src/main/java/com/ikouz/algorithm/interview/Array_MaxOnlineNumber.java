package com.ikouz.algorithm.interview;

import com.ikouz.algorithm.leetcode.utils.TestUtil;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of int pair<P,K> where the P represents enter time and the K represents left time.
 * Please find out the max online number. Note: 0 < P,K <= 86400
 * <p>
 * input: [[1,5], [3,8], [4,20], [50, 89]]
 * output: 3
 */
public class Array_MaxOnlineNumber {

    /**
     * @param list
     * @return
     */
    public static int getMaxNumber(List<Pair<Integer, Integer>> list) {
        if (list == null) {
            return 0;
        }
        int[] records = new int[86400];
        for (Pair<Integer, Integer> pair : list) {
            if (pair == null) {
                continue;
            }
            records[pair.getKey() - 1]++;
            records[pair.getValue() - 1]--;
        }
        int max = 0, sum = 0;
        for (int i = 0; i < records.length; i++) {
            sum += records[i];
            max = max < sum ? sum : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] ints = TestUtil.buildIntArrArr("[[1,5], [3,8], [4,20], [50, 89]]");
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int[] arr : ints) {
            Pair pair = new Pair<>(arr[0], arr[1]);
            list.add(pair);
        }

        System.out.println(getMaxNumber(list));
    }
}
