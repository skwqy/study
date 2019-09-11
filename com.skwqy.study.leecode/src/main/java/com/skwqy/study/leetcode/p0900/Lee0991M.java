package com.skwqy.study.leetcode.p0900;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-01 20:39
 */
public class Lee0991M {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        if (X >= Y) {
            ans = X - Y;
        } else {
            int tmpY = Y >>> 1;
            while (X <= tmpY) {
                X = X << 1;
                ans++;
            }

            int ans1 = 0;
            ans1 = (X - tmpY) + (Y - (tmpY << 1)) + 1;

            int ans2 = 0;
            ans2 = 1 + ((X << 1) - Y);


            ans += Math.min(ans1, ans2);
        }
        return ans;
    }
}
