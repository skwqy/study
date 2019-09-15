package com.skwqy.study.hot100.p0076;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 21:06
 */
public class Lee0076HTest {
    Lee0076H ins = new Lee0076H();

    @Test
    public void minWindow() {
        assertEquals("BANC", ins.minWindow("ADOBECODEBANC", "ABC"));
    }
}