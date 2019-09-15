package com.skwqy.study.hot100.p0055;

/**
 * 这是一个低效的解决方法。我们模拟从第一个位置跳到最后位置的所有方案。
 * 从第一个位置开始，模拟所有可以跳到的位置，然后从当前位置重复上述操作，当没有办法继续跳的时候，就回溯。
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-15 08:47
 */
public class Lee0055M_DP2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 0:未尝试、1：尝试失败、2：尝试成功
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 2;

        for (int i = nums.length - 1; i >= 0; i--) {
            int furthest = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthest; j++) {
                if (memo[j] == 2) {
                    memo[i] = 2;
                    break;
                }
            }
        }
        return memo[0] == 2;
    }
}
