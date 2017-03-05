package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * Created by liujiaming on 2017/02/09 11:48.
 */
public class Sort_274_HIndex {

    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
     * <p/>
     * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
     * <p/>
     * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
     * <p/>
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     * <p/>
     * 总结：
     */
    public static int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }

        // sort
        int tmp;
        for (int i = 0; i < citations.length; i++) {
            for (int j = i + 1; j < citations.length; j++) {
                if (citations[j] > citations[i]) {
                    tmp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = tmp;
                }
            }
        }

        // find
        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= (i + 1)) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }


    public static void main(String[] args) {
        System.out.println(hIndex(TestUtil.buildIntArr("[1,2,3,4,5,6,7]")));
    }
}
