package com.skwqy.study.leetcode.p0000.p0006m;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/11 10:54 PM
 * <p>
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

            for (int j = 0; j + i < s.length(); j += size) {
                // 添加每个列完整的元素
                res.append(s.charAt(j + i));

                // 添加每列只有一个元素的元素
                int tmp = j + size - i;

                // 非首位行则需要添加每列只有一个元素的元素
                if (i != 0 && i != numRows - 1 && tmp < s.length()) {
                    res.append(s.charAt(tmp));
                }
            }
        }
        return res.toString();
    }
}
