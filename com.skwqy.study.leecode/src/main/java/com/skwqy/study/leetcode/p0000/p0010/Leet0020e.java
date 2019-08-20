package com.skwqy.study.leetcode.p0000.p0010;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 16:27
 */
public class Leet0020e {
    private Map<Character, Character> mappings;

    public Leet0020e() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char currentChar = s.charAt(i);
            if (this.mappings.containsKey(currentChar)) {
                char topChar = stack.empty() ? '#' : stack.pop();
                if (topChar != this.mappings.get(currentChar)) {
                    return false;
                }
            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
}
