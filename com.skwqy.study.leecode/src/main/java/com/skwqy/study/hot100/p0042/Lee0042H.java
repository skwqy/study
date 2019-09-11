package com.skwqy.study.hot100.p0042;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-11 21:59
 */
public class Lee0042H {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int sum = 0;
        int leftMax;
        int rightMax;
        for (int i = 1; i < height.length - 1; i++) {
            leftMax = Integer.MIN_VALUE;
            rightMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftMax= Math.max(leftMax,height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                rightMax= Math.max(rightMax,height[j]);
            }
            int realHeight = Math.min(leftMax, rightMax);
            if (realHeight > height[i]) {
                sum += realHeight - height[i];
            }
        }
        return sum;
    }


}
