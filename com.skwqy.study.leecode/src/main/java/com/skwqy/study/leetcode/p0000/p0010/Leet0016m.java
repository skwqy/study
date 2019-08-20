package com.skwqy.study.leetcode.p0000.p0010;

import java.util.Arrays;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 15:12
 */
public class Leet0016m {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("参数错误");
        }
        int len = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (target > sum) {
                    start++;
                } else if (target < sum) {
                    end--;
                } else return result;
            }
        }
        return result;
    }
}
