package com.skwqy.study.hot100.p0152;

class Lee0152M {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0, len = nums.length; i < len; i++) {
            int tmp = 1;
            for (int j = i; j < len; j++) {
                ans = Math.max(ans, tmp = tmp * nums[j]);
            }
        }
        return ans;
    }
}