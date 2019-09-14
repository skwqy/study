package com.skwqy.study.hot100.p0394;

import java.util.Stack;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-12 23:27
 */
public class Lee0394M {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();
        StringBuilder result = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int number = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                number = number * 10 + (c - '0');
            } else if (c == '[') {
                numbers.push(number);
                strings.push(res.toString());
                number = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int repeat = numbers.pop();
                for (int j = 0; j < repeat; j++) {
                    tmp.append(res);
                }
                res = new StringBuilder(strings.pop() + tmp);

            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
