package com.skwqy.study.hot100.p0238;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 20:09
 */
public class Lee0238MTest {
    Lee0238M ins = new Lee0238M();

    @Test
    public void productExceptSelf() {
        int[] inputs = new int[]{1, 2, 3, 4};
        int[] expect = new int[]{24, 12, 8, 6};
        assertArrayEquals(expect, ins.productExceptSelf(inputs));
    }
}