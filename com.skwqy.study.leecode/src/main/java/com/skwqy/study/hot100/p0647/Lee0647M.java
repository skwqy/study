package com.skwqy.study.hot100.p0647;

/**
 * 中心法
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-13 10:47
 */
public class Lee0647M {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += getSegment(s, i, i);
            result += getSegment(s, i, i + 1);
        }
        return result;
    }

    private int getSegment(String s, int leftIndex, int rightIndex) {
        int count = 0;
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            count++;
            leftIndex--;
            rightIndex++;
        }
        return count;
    }
}
