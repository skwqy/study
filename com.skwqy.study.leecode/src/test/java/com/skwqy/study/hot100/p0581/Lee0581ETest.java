package com.skwqy.study.hot100.p0581;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 17:34
 */
public class Lee0581ETest {
    Lee0581E ins = new Lee0581E();

    @Test
    public void findUnsortedSubarray() {
        assertEquals(5, ins.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    @Test
    public void findUnsortedSubarray2() {
        assertEquals(2, ins.findUnsortedSubarray(new int[]{2, 1}));
    }

    @Test
    public void findUnsortedSubarray3() {
        assertEquals(0, ins.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }
}