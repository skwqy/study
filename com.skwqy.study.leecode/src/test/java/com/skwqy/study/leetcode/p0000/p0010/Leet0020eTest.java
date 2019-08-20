package com.skwqy.study.leetcode.p0000.p0010;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 16:28
 */
public class Leet0020eTest {
    Leet0020e instance = new Leet0020e();
    @Test
    public void isValid() {
        String input = "()";
        assertTrue(instance.isValid(input));
    }

    @Test
    public void isValid2() {
        String input = "()[]{}";
        assertTrue(instance.isValid(input));
    }

    @Test
    public void isValid3() {
        String input = "(]";
        assertFalse(instance.isValid(input));
    }

    @Test
    public void isValid4() {
        String input =  "([)]";
        assertFalse(instance.isValid(input));
    }



}