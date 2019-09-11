package com.skwqy.study.hot100.p0003;

import java.util.HashSet;
import java.util.Set;

/**
 * 暴力：枚举出所有可能的字符串组合，判断字符串是否存在重复字符
 *
 * @author skwqy
 * @Created on 2019 09 2019-09-04 21:59
 */
public class Lee0003M2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] index = new int[128];
        int ans = 0;
        for (int i = 0, j = 0, len = s.length(); j < len; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;  //TODO 注意此处的+1处理
        }
        return ans;
    }

}
