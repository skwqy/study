package com.skwqy.study.hot100.p0053;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-15 08:23
 */
public class Lee0053ETest {
    Lee0053E ins = new Lee0053E();

    @Test
    public void maxSubArray() {
        assertEquals(6, ins.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}