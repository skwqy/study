package com.skwqy.study.hot100.p0152;

class Lee0152M2 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int ans = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        int max, min;
        for (int i = 1, len = nums.length; i < len; i++) {
            max = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            min = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            ans = Math.max(ans, max);
            preMax = max;
            preMin = min;
        }
        return ans;
    }
}