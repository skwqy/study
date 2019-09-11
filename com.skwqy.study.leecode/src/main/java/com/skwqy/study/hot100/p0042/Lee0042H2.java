package com.skwqy.study.hot100.p0042;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-11 21:59
 */
public class Lee0042H2 {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }


        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int realHeight = Math.min(leftMax[i], rightMax[i]);
            if (realHeight > height[i]) {
                sum += realHeight - height[i];
            }
        }
        return sum;
    }


}
