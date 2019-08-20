package com.skwqy.study.leetcode.p0000.p0010;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 18:17
 */
public class Leet0026e {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int resultIndex = 0;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] != nums[resultIndex]) {
                resultIndex++;
                nums[resultIndex] = nums[i];
            }
        }
        return resultIndex + 1;
    }
}
