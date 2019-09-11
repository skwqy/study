package com.skwqy.study.hot100.p0221;

import java.util.Map;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 12:23
 */
public class Lee0221M {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int maxSideLen = 0;
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (matrix[r][c] == '1') {
                    int sideLen = 1;
                    boolean flag = true;
                    while (r + sideLen < rLen && c + sideLen < cLen && flag) {
                        for (int nc = c; nc <= c + sideLen; nc++) {
                            if (matrix[r + sideLen][nc] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int nr = r; nr <= r + sideLen; nr++) {
                            if (matrix[nr][c + sideLen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            sideLen++;
                        }
                    }
                    maxSideLen = Math.max(maxSideLen, sideLen);
                }
            }
        }
        return maxSideLen * maxSideLen;
    }
}
