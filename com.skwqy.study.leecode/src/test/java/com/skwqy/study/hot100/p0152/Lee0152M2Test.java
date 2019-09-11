package com.skwqy.study.hot100.p0152;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-05 23:32
 */
public class Lee0152M2Test {

    Lee0152M2 ins = new Lee0152M2();

    @Test
    public void maxProduct() {
        assertEquals(6, ins.maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    public void maxProduct2() {
        assertEquals(48, ins.maxProduct(new int[]{2, 3, -2, -4}));
    }

    @Test
    public void maxProduct3() {
        assertEquals(0, ins.maxProduct(new int[]{-2, 0, -1}));
    }
}