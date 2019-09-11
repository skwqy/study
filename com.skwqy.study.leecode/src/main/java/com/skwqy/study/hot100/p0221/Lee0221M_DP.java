package com.skwqy.study.hot100.p0221;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 12:23
 */
public class Lee0221M_DP {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int[][] dp = new int[rLen + 1][cLen + 1];
        int maxSideLen = 0;
        for (int r = 1; r <= rLen; r++) {
            for (int c = 1; c <= cLen; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1])+1;
                    maxSideLen = Math.max(maxSideLen, dp[r][c]);
                }
            }
        }
        return maxSideLen * maxSideLen;
    }
}
