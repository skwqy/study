package com.skwqy.study.leecode.p0001to0100.p0001e;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度 O(N)
 * 缺点：占用额外的空间
 * @author skwqy
 * @Created on 2018 12 2018/12/3 10:11 PM
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null){
            throw new IllegalArgumentException();
        }
        Map<Integer,Integer> numMap = new HashMap<>(nums.length);
        for (int index = 0;index < nums.length;index++){
            numMap.put(nums[index],index);
        }

        int another;
        Integer anotherIndex;
        for(int index =0;index<nums.length;index++){
            another = target - nums[index];
            anotherIndex = numMap.get(another);
            if(anotherIndex != null && anotherIndex.intValue() != index){
                return new int[]{index,anotherIndex.intValue()};
            }
        }
        throw new IllegalArgumentException();
    }
}
