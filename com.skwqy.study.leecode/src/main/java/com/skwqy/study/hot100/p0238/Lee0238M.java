package com.skwqy.study.hot100.p0238;

import java.util.Arrays;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 18:14
 */
public class Lee0238M {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
