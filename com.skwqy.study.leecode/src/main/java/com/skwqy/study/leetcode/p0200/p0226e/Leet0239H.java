package com.skwqy.study.leetcode.p0200.p0226e;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-20 23:39
 */
public class Leet0239H {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0, len = nums.length; i <= len - k; i++) {
            result[i] = getMax(nums, i, k);
        }
        return result;
    }

    int getMax(int[] nums, int startIndex, int len) {
        int max = Integer.MIN_VALUE;
        for (int i = startIndex; i < startIndex + len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
