package com.skwqy.study.leetcode.p0000.p0004h;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/7 7:53 PM
 */
public class MedianOfTwoSortedArrays2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0d;
        }
        int mLen = nums1.length, nLen = nums2.length;
        int len = mLen + nLen;
        int[] allNumb = new int[len];
        int index = 0;
        for (int i = 0, j = 0; i < mLen || j < nLen; ) {

            if (i == mLen && j < nLen) {
                allNumb[index++] = nums2[j++];
            } else if (i < mLen && j == nLen) {
                allNumb[index++] = nums1[i++];
            }
            else if (i < mLen && j < nLen) {
                if (nums1[i] <= nums2[j]) {
                    allNumb[index++] = nums1[i];
                    if (i < mLen) {
                        i++;
                    }
                } else {
                    allNumb[index++] = nums2[j];
                    if (j < nLen) {
                        j++;
                    }
                }
            }
        }


        if (len % 2 == 1) {
            return allNumb[len / 2];
        }
        return (allNumb[len / 2 - 1] + allNumb[len / 2]) / 2.0;
    }
}
