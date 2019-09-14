package com.skwqy.study.hot100.p0394;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 08:29
 */
public class Lee0394MTest {
    Lee0394M ins = new Lee0394M();

    @Test
    public void decodeString() {
        String inputs = "3[a]2[bc]";
        assertEquals("aaabcbc",ins.decodeString(inputs));
    }

    @Test
    public void decodeString2() {
        String inputs = "3[a2[bc]]";
        assertEquals("abcbcabcbcabcbc",ins.decodeString(inputs));
    }
}