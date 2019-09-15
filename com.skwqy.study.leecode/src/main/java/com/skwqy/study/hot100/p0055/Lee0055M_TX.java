package com.skwqy.study.hot100.p0055;

/**
 * 类似于DP2
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-15 08:47
 */
public class Lee0055M_TX {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
