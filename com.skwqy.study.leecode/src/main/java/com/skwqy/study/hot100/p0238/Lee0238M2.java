package com.skwqy.study.hot100.p0238;

import java.util.Arrays;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 18:14
 */
public class Lee0238M2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < len; i++) {
            ans[i] *= left;
            left = left * nums[i];

            ans[len - 1 - i] *= right;
            right *= nums[len - 1 - i];
        }
        return ans;
    }
}
