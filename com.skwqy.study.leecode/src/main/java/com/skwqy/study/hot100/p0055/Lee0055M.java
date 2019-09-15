package com.skwqy.study.hot100.p0055;

/**
 * 类似于DP2
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-15 08:47
 */
public class Lee0055M {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        boolean found = false;
        for (int i = nums.length - 1; i > 0; i--) {
            found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= (i - j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
