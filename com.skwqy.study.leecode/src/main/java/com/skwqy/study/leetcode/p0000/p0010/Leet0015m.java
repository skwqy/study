package com.skwqy.study.leetcode.p0000.p0010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 14:22
 */
public class Leet0015m {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < len - 2; i++) {
            // 当前数字大于0，则三数之和一定大于0,结束循环
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;   //去重
                    while (left < right && nums[right] == nums[right - 1]) right--;  //去重
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }
}
