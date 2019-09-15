package com.skwqy.study.hot100.p0213;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-15 10:48
 */
public class Lee0070E_DP {
    public int climbStairs(int n) {
        int len = n > 3 ? n : 3;
        int[] dp = new int[len + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
