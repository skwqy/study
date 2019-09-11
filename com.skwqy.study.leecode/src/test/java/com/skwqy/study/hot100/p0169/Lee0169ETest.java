package com.skwqy.study.hot100.p0169;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-06 23:25
 */
public class Lee0169ETest {
    Lee0169E ins = new Lee0169E();

    @Test
    public void majorityElement() {
        assertEquals(3, ins.majorityElement(new int[]{3, 2, 3}));
    }

    @Test
    public void majorityElement2() {
        assertEquals(2, ins.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}