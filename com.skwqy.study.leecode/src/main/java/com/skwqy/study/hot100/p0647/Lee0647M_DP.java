package com.skwqy.study.hot100.p0647;

/**
 * 中心法
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-13 10:47
 */
public class Lee0647M_DP {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
