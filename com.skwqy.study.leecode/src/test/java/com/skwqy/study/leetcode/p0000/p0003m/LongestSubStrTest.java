package com.skwqy.study.leetcode.p0000.p0003m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/6 9:55 PM
 */
public class LongestSubStrTest {

    @Test
    public void testLengthOfLongestSubstring(){
        LongestSubStr longestSubStr = new LongestSubStr();
        Assert.assertEquals(3,longestSubStr.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1,longestSubStr.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3,longestSubStr.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(2,longestSubStr.lengthOfLongestSubstring("au"));
    }
}