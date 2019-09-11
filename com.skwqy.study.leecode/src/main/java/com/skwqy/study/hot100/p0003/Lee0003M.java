package com.skwqy.study.hot100.p0003;

import java.util.HashSet;
import java.util.Set;

/**
 * 暴力：枚举出所有可能的字符串组合，判断字符串是否存在重复字符
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-04 21:59
 */
public class Lee0003M {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ans = 0;
        String tmp;
        for (int i = 0, len = s.length(); i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                tmp = s.substring(i, j);
                if (hasDumplicateChar(tmp)) {
                    ans = Math.max(ans, tmp.length());
                }

            }
        }
        return ans;
    }

    private boolean hasDumplicateChar(String s) {
        Set<Character> chars = new HashSet<>(s.length());
        char[] allChars = s.toCharArray();
        for (int i = 0; i < allChars.length; i++) {
            if (chars.contains(allChars[i])) {
                return false;
            }
            chars.add(allChars[i]);
        }
        return true;
    }
}
