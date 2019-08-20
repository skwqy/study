package com.skwqy.study.leetcode.p0000.p0010;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 11:06
 */
public class Leet0014ETest {
    Leet0014e instance = new Leet0014e();
    @Test
    public void longestCommonPrefix() {
        String[] inputs = {"flower","flow","flight"};
        assertEquals("fl",instance.longestCommonPrefix(inputs));

    }

    @Test
    public void longestCommonPrefix2() {
        String[] inputs = {"dog","racecar","car"};
        assertEquals("",instance.longestCommonPrefix(inputs));

    }

    @Test
    public void longestCommonPrefix3() {
        String[] inputs = {"c","c"};
        assertEquals("c",instance.longestCommonPrefix(inputs));

    }
}