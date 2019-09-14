package com.skwqy.study.hot100.p0146;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-12 21:40
 */
public class Lee0213MTest {
    Lee0213M ins = new Lee0213M();

    @Test
    public void rob() {
        assertEquals(3, ins.rob(new int[]{2, 3, 2}));
    }

    @Test
    public void rob2() {
        assertEquals(4, ins.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void rob3() {
        assertEquals(1, ins.rob(new int[]{1}));
    }
}