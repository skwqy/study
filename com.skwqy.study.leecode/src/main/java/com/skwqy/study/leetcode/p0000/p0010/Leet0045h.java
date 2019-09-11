package com.skwqy.study.leetcode.p0000.p0010;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-20 23:18
 */
public class Leet0045h {
    public int jump(int[] nums) {
        int postion = nums.length - 1;
        int steps = 0;
        while (postion != 0) {
            for (int i = 0; i < postion; i++) {
                if (nums[i] + i >= postion) {
                    postion = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
