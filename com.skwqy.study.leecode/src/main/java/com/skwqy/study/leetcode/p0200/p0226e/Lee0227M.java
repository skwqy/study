package com.skwqy.study.leetcode.p0200.p0226e;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-01 16:32
 */
public class Lee0227M {
    private static final Character[][] ALL_OPS = {{'*', '/'}, {'+', '-'}};
    private static final Pattern REG_OPS = Pattern.compile("@[0-9]|[0-9]");
    private static final Pattern REG_NUMBS = Pattern.compile("\\*|\\/|\\+|\\-");

    public int calculate(String s) {

        s = s.replaceAll("\\s+", "");
        while (s.indexOf('(') != -1) {
            int lIndex = s.lastIndexOf("(");
            int rIndex = s.indexOf(")", lIndex);
            int result = doCalculate(s.substring(lIndex + 1, rIndex));
            calculate(s = (s.substring(0, lIndex) + result + s.substring(rIndex + 1)));
        }
        return Integer.valueOf(doCalculate(s));
    }

    private int doCalculate(String expression) {
        String exp = minus2Negative(expression);
        List<Character> ops = getOps(exp);
        List<Integer> numbs = getNumbs(exp);
        for (Character[] tmpOps : ALL_OPS) {
            for (int i = 0; i < ops.size(); ) {
                if (isMatchOp(tmpOps, ops.get(i))) {
                    numbs.add(i, cal(ops.remove(i), numbs.remove(i), numbs.remove(i)));
                } else {
                    i++;
                }
            }
        }
        return numbs.remove(0);
    }

    private int cal(char op, int lValue, int rValue) {
        switch (op) {
            case '+':
                return lValue + rValue;
            case '-':
                return lValue - rValue;
            case '*':
                return lValue * rValue;
            case '/':
                return lValue / rValue;
            default:
                return 0;
        }

    }

    private boolean isMatchOp(Character[] ops, char op) {
        for (char tmpOp : ops) {
            if (tmpOp == op) {
                return true;
            }
        }
        return false;
    }


    private List<Character> getOps(String exp) {
        String[] ops = REG_OPS.split(exp);
        return Arrays.stream(ops)
                .filter((op) -> !op.isEmpty())
                .map((op) -> op.charAt(0))
                .collect(Collectors.toList());
    }

    private List<Integer> getNumbs(String exp) {
        return Arrays.stream(REG_NUMBS.split(exp))
                .map((op) -> op.replaceAll("@", "-"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private String minus2Negative(String expression) {
        char[] expChar = expression.toCharArray();
        for (int i = 0; i < expChar.length; i++) {
            if (isNegative(expChar, i)) {
                expChar[i] = '@';
            }
        }
        return String.valueOf(expChar);
    }

    private boolean isNegative(char[] expChar, int index) {
        return expChar[index] == '-' && (index == 0 || isOpe(expChar[index - 1]));
    }

    private boolean isOpe(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }


}
