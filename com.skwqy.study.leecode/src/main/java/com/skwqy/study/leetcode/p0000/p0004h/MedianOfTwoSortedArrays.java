package com.skwqy.study.leetcode.p0000.p0004h;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/7 7:53 PM
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0d;
        }
        int m = nums1.length;
        int n = nums2.length;

        // 确保nums1数组的长度小于nums2数组的长度，便于后续以nums1数组长度作为比较的区间
        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmpLength = m;
            m = n;
            n = tmpLength;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            // 长数组中分后小数组最大值 > 短数组中分后大数组最小值
            if (i < iMax && nums2[j-1] > nums1[i]) {
                iMin = i + 1;
            }
            // 短数组中分后小数组最大值 > 长数组中分后大数组最小值
            else if(i > iMin && nums1[i-1] > nums2[j]){
                iMax = i-1;
            }
            else{
                int maxLeft = 0;
                if (i == 0){
                    maxLeft = nums2[j-1];
                }
                else if(j == 0){
                    maxLeft = nums1[i-1];
                }
                else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if ((m+n)/2 ==1){
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m){
                    minRight = nums2[j];
                }
                else if(j == n){
                    minRight = nums1[i];
                }
                else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }

        }
        return 0.0;
    }
}
