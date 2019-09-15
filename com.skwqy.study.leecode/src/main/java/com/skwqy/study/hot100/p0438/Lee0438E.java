package com.skwqy.study.hot100.p0438;

import java.util.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 19:51
 */
public class Lee0438E {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        for (Character c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int match = 0;
        List<Integer> result = new LinkedList<>();
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
                if (right - left == p.length()) {
                    result.add(left);
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return result;
    }
}
