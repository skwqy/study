package com.skwqy.study.hot100.p0560;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 09:53
 */
public class Lee0560M {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int sum = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
