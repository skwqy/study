package com.skwqy.study.leetcode.p0000.p0005m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/8 8:35 PM
 */
public class LongestSubstringTest {

    @Test
    public void longestPalindrome() {
        LongestSubstring longestSubstring = new LongestSubstring();
        Assert.assertEquals("bab",longestSubstring.longestPalindrome("babad"));
    }
}