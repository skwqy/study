package com.skwqy.study.leetcode.p0000.p0006m;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/11 10:54 PM
 *
 * 0   6   C   I
 * 1  57  BD  HJ
 * 2 4 8 A E G K
 * 3   9   F   L
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        // 首位两行中相邻两个元素的index之差跟行数是相关的
        int size = 2 * numRows - 2;

        for (int i = 0; i < numRows; ++i) {
            
            for (int j = i; j < s.length(); j += size) {
                res.append(s.substring(j, j + 1));
                int tmp = j + size - 2 * i;

                // 非首位行
                if (i != 0 && i != numRows - 1 && tmp < s.length()) {
                    res.append(s.substring(tmp, tmp + 1));
                }
            }
        }
        return res.toString();
    }
}
