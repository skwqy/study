package com.skwqy.study.leetcode.p0000.p0003m;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/6 9:55 PM
 */
public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        StringBuilder tmpBuffer = new StringBuilder(s.length());
        tmpBuffer.append(s.charAt(0));
        int maxLen = 1, foundIndex = 0;
        for (int index = 1, length = s.length(); index < length; index++) {
            String ch = s.substring(index, index + 1);
            foundIndex = tmpBuffer.indexOf(ch);
            if (foundIndex < 0) {
                tmpBuffer.append(ch);
                maxLen = Math.max(maxLen, tmpBuffer.length());
            } else {
                tmpBuffer.delete(0, foundIndex + 1);
                tmpBuffer.append(ch);
            }
        }
        return maxLen;
    }
}
