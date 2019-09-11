package com.skwqy.study.hot100.p0169;

import java.util.HashMap;
import java.util.Map;

import sun.awt.SunHints;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-06 23:20
 */
public class Lee0169E {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> all = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = all.get(nums[i]);
            if (val != null) {
                val++;
            } else {
                val = 1;
            }
            all.put(nums[i], val);
        }
        for (Map.Entry<Integer, Integer> entry : all.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("invalid operation.");
    }
}
