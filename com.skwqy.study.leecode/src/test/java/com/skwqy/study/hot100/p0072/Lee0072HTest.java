package com.skwqy.study.hot100.p0072;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-15 14:12
 */
public class Lee0072HTest {
    Lee0072H ins = new Lee0072H();

    @Test
    public void minDistance() {
        assertEquals(3, ins.minDistance("horse", "ros"));
    }

    @Test
    public void minDistance2() {
        assertEquals(5, ins.minDistance("intention", "execution"));
    }
}