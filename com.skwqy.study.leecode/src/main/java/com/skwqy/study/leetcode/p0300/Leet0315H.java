package com.skwqy.study.leetcode.p0300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-28 22:49
 */
public class Leet0315H {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            result.add(lessCount(nums, i + 1, nums[i]));
        }
        return result;
    }

    int lessCount(int[] nums, int startIndex, int number) {
        int count = 0;
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] < number) {
                count++;
            }
        }
        return count;
    }
}
