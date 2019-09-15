package com.skwqy.study.hot100.p0076;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 20:51
 */
public class Lee0076H {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        for (Character c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int match = 0;
        String ans = "";
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                String target = s.substring(left, right);
                if (ans.isEmpty()) {
                    ans = target;
                } else {
                    if (ans.length() > target.length()) {
                        ans = target;
                    }
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return ans;
    }
}
