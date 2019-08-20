package com.skwqy.study.leetcode.p0000.p0010;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 10:43
 */
public class Leet0011m {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, (j - i) * Math
                        .min(height[j], height[i]));
            }
        }
        return max;
    }
}
