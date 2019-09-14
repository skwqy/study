package com.skwqy.study.hot100.p0581;

import java.util.Arrays;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 17:10
 */
public class Lee0581E {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsClone = nums.clone();
        Arrays.sort(numsClone);
        int startIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == numsClone[i]) {
                startIndex = i;
            } else {
                break;
            }
        }
        int endIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == numsClone[i]) {
                endIndex--;
            } else {
                break;
            }
        }
        if (startIndex >= endIndex) {
            return 0;
        }
        return endIndex - startIndex;
    }
}
