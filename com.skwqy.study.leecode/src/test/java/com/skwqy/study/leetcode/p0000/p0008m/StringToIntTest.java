package com.skwqy.study.leetcode.p0000.p0008m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/14 10:58 PM
 */
public class StringToIntTest {

    @Test
    public void myAtoi() {
        StringToInt stringToInt = new StringToInt();
        Assert.assertEquals(42,stringToInt.myAtoi("42"));
        Assert.assertEquals(42,stringToInt.myAtoi("+42"));
        Assert.assertEquals(-42,stringToInt.myAtoi("-42"));
        Assert.assertEquals(4193,stringToInt.myAtoi("4193 with words"));
        Assert.assertEquals(0,stringToInt.myAtoi("words and 987"));
        Assert.assertEquals(-42,stringToInt.myAtoi(" -42"));
    }
}