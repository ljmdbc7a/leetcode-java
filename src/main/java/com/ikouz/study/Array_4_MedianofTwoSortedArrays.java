package com.ikouz.study;

/**
 * Created by liujiaming on 2016/07/17 00:54.
 */
public class Array_4_MedianofTwoSortedArrays {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * <p/>
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p/>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p/>
     * The median is 2.0
     * <p/>
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p/>
     * The median is (2 + 3)/2 = 2.5
     * <p/>
     * 描述：寻找两个有序数组的中位数
     * 总结：双指针。注意判断单个移动到边界时的条件。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = mergeSortedArray(nums1, nums2);
        if(merge == null){
            return 0;
        }
        int len = merge.length;
        int mid = len/2;
        if(len % 2 == 1){
            return (double)merge[mid];
        }else{
            return ((double)(merge[mid-1] + merge[mid])) / 2;
        }
    }

    private static int[] mergeSortedArray(int[] nums1, int[] nums2){
        if (nums1 == null && nums2 == null){
            return null;
        }
        if (nums1 == null && nums2 != null){
            return nums2;
        }
        if (nums1 != null && nums2 == null){
            return nums1;
        }
        int i = 0, j = 0, c = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] merge = new int[len1 + len2];
        while (i < len1 || j < len2){
            if(j == len2 || (i != len1 && nums1[i] <= nums2[j])){
                merge[c] = nums1[i];
                c++;
                i++;
            }else if (i == len1 || (j != len2 && nums1[i] > nums2[j])){
                merge[c] = nums2[j];
                c++;
                j++;
            }
        }
        return merge;
    }
}
