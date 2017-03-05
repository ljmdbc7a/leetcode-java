package com.ikouz.algorithm.leetcode;

import com.ikouz.algorithm.leetcode.utils.TestUtil;

/**
 * @author liujiaming
 * @since 2017/03/04
 */
public class HashTable_463_IslandPerimeter {

    /**
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
     * Grid cells are connected horizontally/vertically (not diagonally).
     * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
     * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
     * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     * <p>
     * Example:
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * Answer: 16
     * Explanation: The perimeter is the 16 yellow stripes in the image below:
     * https://leetcode.com/static/images/problemset/island.png
     * <p>
     * 总结：
     */
    public static int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    } else {
                        perimeter++;
                    }
                    if (i + 1 < grid.length && grid[i+1][j] == 1) {
                    } else {
                        perimeter++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    } else {
                        perimeter++;
                    }
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                    } else {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr[0] = TestUtil.buildIntArr("[0,1,0,0]");
        arr[1] = TestUtil.buildIntArr("[1,1,1,0]");
        arr[2] = TestUtil.buildIntArr("[0,1,0,0]");
        arr[3] = TestUtil.buildIntArr("[1,1,0,0]");
        System.out.println(islandPerimeter(arr));
    }
}
