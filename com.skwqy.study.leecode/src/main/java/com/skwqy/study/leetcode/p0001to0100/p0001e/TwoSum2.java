package com.skwqy.study.leetcode.p0001to0100.p0001e;

/**
 * 时间复杂度：O(N^2)
 * @author skwqy
 * @Created on 2018 12 2018/12/3 11:36 PM
 */
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null){
            throw new IllegalArgumentException();
        }
        int length = nums.length;
        for (int i=0;i<length;i++)
        {
            for (int j=i+1;j<length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
