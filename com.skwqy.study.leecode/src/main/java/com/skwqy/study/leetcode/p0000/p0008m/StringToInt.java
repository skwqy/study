package com.skwqy.study.leetcode.p0000.p0008m;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/14 10:38 PM
 */
public class StringToInt {

    public int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }

        int ans = 0;
        boolean first = true;
        int sign = 1;
        String trimStr = str.trim();
        char firstChar = trimStr.charAt(0);
        int beginIndex = 0;
        if (firstChar == '-') {
            sign = -1;
            beginIndex = 1;
        }
        if (firstChar == '+') {
            beginIndex = 1;
        }

        try {
            for (int i = beginIndex, length = trimStr.length(); i < length; i++) {
                char indexTmp = trimStr.charAt(i);
                if (indexTmp < 48 || indexTmp > 57) {
                    break;
                }

                if (indexTmp >= 48 && indexTmp <= 57) {
                    int tmp = ans * sign;
                    int indexValue = Integer.valueOf(String.valueOf(indexTmp));
                    if (tmp > Integer.MAX_VALUE / 10 || (tmp == Integer.MAX_VALUE / 10 && indexValue > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    if (tmp < Integer.MIN_VALUE / 10 || (tmp == Integer.MIN_VALUE / 10 && indexValue > 8)) {
                        return Integer.MIN_VALUE;
                    }

                    ans = ans * 10 + Integer.valueOf(String.valueOf(indexTmp));
                }
            }
        } catch (NumberFormatException e) {
        }

        return (ans * sign);
    }
}
