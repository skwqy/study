package com.skwqy.study.leetcode.p0200.p0226e;

import java.util.Stack;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-01 19:14
 */
public class Lee0227MStack {
    public int calculate(String s) {
        Stack<Integer> numbs = new Stack<>();
        int len = s.length();
        int num = 0;
        int res = 0;
        char op = '+';
        char[] c = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (c[i] >= '0') {
                num = num * 10 + (c[i] - '0');
            }
            if ((c[i] < '0' && c[i] != ' ') || i == len - 1) {
                if (op == '+') {
                    numbs.push(num);

                }
                if (op == '-') numbs.push(-num);
                if (op == '*' || op == '/') {
                    int tmp = (op == '*') ? numbs.pop() * num : numbs.pop() / num;
                    numbs.push(tmp);
                }
                op = c[i];
                num = 0;
            }
        }
        while (!numbs.empty()) {
            res += numbs.pop();
        }
        return res;
    }
}
