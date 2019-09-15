package com.skwqy.study.hot100.p0049;

import java.util.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 23:05
 */
public class Lee0049M {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList());
            }
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
