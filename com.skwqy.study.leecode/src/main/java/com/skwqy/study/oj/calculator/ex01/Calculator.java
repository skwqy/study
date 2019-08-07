package com.skwqy.study.oj.calculator.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-02 21:12
 */
public class Calculator {
    private static final Logger LOG = LoggerFactory.getLogger(Calculator.class);
    private static final char[][] ALL_OPS = {{'*', '/'}, {'+', '-'}};
    private static final Pattern REG_OP = Pattern.compile("@[0-9]|[0-9]");
    private static final Pattern REG_NUMBER = Pattern.compile("\\+|\\-|\\*|\\/");


    public static String calculator(String express) {
        return "";
    }

    static String doCalcWithBreackets(String srcExpress) {
        while (srcExpress.lastIndexOf('(') != -1) {
            int leftIndex = srcExpress.lastIndexOf('(');
            int rightIndex = srcExpress.indexOf(')',leftIndex);
            if(rightIndex == -1){
                throw new IllegalArgumentException("arguments is invalid.");
            }
            String tmpExp = srcExpress.substring(leftIndex+1,rightIndex);
            LOG.info(tmpExp);
            if(leftIndex > 2) {
                String tmpOp = srcExpress.substring(leftIndex - 3, leftIndex);
                if ("MAX".equals(tmpOp)) {
                    String result = doCalcWithMax(tmpExp);
                    srcExpress = srcExpress.substring(0,leftIndex-3)+result+srcExpress.substring(rightIndex+1);
                    continue;
                } else if ("MIN".equals(tmpOp)) {
                    String result = doCalcWithMin(tmpExp);
                    srcExpress = srcExpress.substring(0,leftIndex-3)+result+srcExpress.substring(rightIndex+1);
                    continue;
                }
            }
            String result = doCalcWithoutBreackets(srcExpress.substring(leftIndex+1,rightIndex));
            srcExpress = srcExpress.substring(0,leftIndex)+result+srcExpress.substring(rightIndex+1);
        }
        return doCalcWithoutBreackets(srcExpress);
    }
    static String doCalcWithMax(String srcExpress){
        String[] numbers = srcExpress.split(",");
        String lValue = doCalcWithoutBreackets(numbers[0]);
        String rValue = doCalcWithoutBreackets(numbers[1]);
        double result = Math.max(Double.parseDouble(lValue),Double.parseDouble(rValue));
        return Double.toString(result);
    }
    static String doCalcWithMin(String srcExpress){
        String[] numbers = srcExpress.split(",");
        String lValue = doCalcWithoutBreackets(numbers[0]);
        String rValue = doCalcWithoutBreackets(numbers[1]);
        double result = Math.min(Double.parseDouble(lValue),Double.parseDouble(rValue));
        return Double.toString(result);
    }

    static String doCalcWithoutBreackets(String srcExpress) {
        String express = minus2Neg(srcExpress);
        List<Character> ops = getOps(express);
        List<Double> numbers = getNumbers(express);
        for (char[] tmpOps : ALL_OPS) {
            for (int i = 0; i < ops.size(); i++) {
                char tmpOp = ops.get(i);
                if (matchedOp(tmpOp, tmpOps)) {
                    numbers.add(i, calc(tmpOp, numbers.remove(i), numbers.remove(i)));
                }
            }
        }
        return numbers.get(0).toString();
    }

    static double calc(char op, double lValue, double rValue) {
        switch (op) {
            case '*':
                return lValue * rValue;
            case '/':
                return lValue / rValue;
            case '+':
                return lValue + rValue;
            case '-':
                return lValue - rValue;
            default:
                throw new NoSuchElementException("No such op,op=" + op);
        }
    }

    static boolean matchedOp(char op, char[] ops) {
        for (char tmpOp : ops) {
            if (tmpOp == op) {
                return true;
            }
        }
        return false;
    }

    static List<Character> getOps(String srcExpress) {
        return Arrays.stream(REG_OP.split(srcExpress))
                .filter(StringUtils::isNoneBlank)
                .map(op -> op.charAt(0))
                .collect(Collectors.toList());
    }

    static List<Double> getNumbers(String srcExpress) {
        return Arrays.stream(REG_NUMBER.split(srcExpress))
                .filter(StringUtils::isNoneBlank)
                .map(Calculator::other2Neg)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    static String other2Neg(String number) {
        return number.replaceAll("@", "-");
    }

    static String minus2Neg(String srcExpress) {
        if (srcExpress == null || srcExpress.isEmpty()) {
            return srcExpress;
        }

        char[] charExpress = srcExpress.toCharArray();
        for (int i = 0, len = charExpress.length; i < len; i++) {
            if (isNeg(charExpress, i)) {
                charExpress[i] = '@';
            }
        }
        return String.valueOf(charExpress);
    }

    static boolean isNeg(char[] charExpress, int index) {
        return charExpress[index] == '-' && (index == 0 || isOp(charExpress[index - 1]));
    }

    static boolean isOp(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    static String formatExp(String srcExpress) {
        if (srcExpress == null || srcExpress.isEmpty()) {
            return srcExpress;
        }
        return srcExpress.replaceAll("\\s*", "");
    }
}
