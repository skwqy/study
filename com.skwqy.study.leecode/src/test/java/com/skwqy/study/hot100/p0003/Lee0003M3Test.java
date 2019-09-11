package com.skwqy.study.hot100.p0003;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-04 22:38
 */
public class Lee0003M3Test {

    Lee0003M3 ins = new Lee0003M3();

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(3, ins.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void lengthOfLongestSubstring2() {
        assertEquals(1, ins.lengthOfLongestSubstring("bbbbbb"));
    }

    @Test
    public void lengthOfLongestSubstring3() {
        assertEquals(3, ins.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void lengthOfLongestSubstring4() {
        assertEquals(1, ins.lengthOfLongestSubstring(" "));
    }

    @Test
    public void lengthOfLongestSubstring5() {
        assertEquals(9, ins.lengthOfLongestSubstring("123456789"));
    }
}