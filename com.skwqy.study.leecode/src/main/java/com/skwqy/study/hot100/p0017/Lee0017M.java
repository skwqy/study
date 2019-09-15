package com.skwqy.study.hot100.p0017;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 22:23
 */
public class Lee0017M {
    private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            backTrack("", digits);
        }
        return result;
    }

    private void backTrack(String combine, String nextDigits) {
        if (nextDigits.isEmpty()) {
            result.add(combine);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                char c = letters.charAt(i);
                backTrack(combine + c, nextDigits.substring(1));
            }
        }
    }
}
