package com.skwqy.study.hot100.p0146;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-12 21:33
 */
public class Lee0213M {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp1 = new int[len + 2];
        for (int i = 0; i < len - 1; i++) {
            dp1[i + 2] = Math.max(dp1[i] + nums[i], dp1[i + 1]);
        }
        int[] dp2 = new int[len + 2];
        for (int i = 1; i < len; i++) {
            dp2[i + 2] = Math.max(dp2[i] + nums[i], dp2[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < len + 2; i++) {
            ans = Math.max(ans, Math.max(dp1[i], dp2[i]));
        }
        return ans;
    }
}
