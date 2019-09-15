package com.skwqy.study.hot100.p0055;

/**
 * 这是一个低效的解决方法。我们模拟从第一个位置跳到最后位置的所有方案。
 * 从第一个位置开始，模拟所有可以跳到的位置，然后从当前位置重复上述操作，当没有办法继续跳的时候，就回溯。
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-15 08:47
 */
public class Lee0055M_BT {
    public boolean canJump(int[] nums) {
        return backtrace(0, nums);
    }

    private boolean backtrace(int start, int[] nums) {
        if (start == nums.length - 1) {
            return true;
        }

        int furthest = Math.min(start + nums[start], nums.length - 1);
        for (int i = start + 1; i <= furthest; i++) {
            if (backtrace(i, nums)) {
                return true;
            }
        }
        return false;
    }
}
