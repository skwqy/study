package com.skwqy.study.hot100.p0003;

/**
 * 暴力：枚举出所有可能的字符串组合，判断字符串是否存在重复字符
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-04 21:59
 */
public class Lee0003M3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        StringBuilder tmp = new StringBuilder();
        int ans = 0;
        String sChar;
        for (int i = 0, len = s.length(); i < len; i++) {
            sChar = s.substring(i, i + 1);
            int index = tmp.indexOf(sChar);
            if (index > 0) {
                ans = Math.max(ans, tmp.length());
                tmp.delete(0, index + 1);
            } else {
                tmp.append(sChar);
            }
        }
        ans = Math.max(ans, tmp.length());
        return ans;
    }

}
