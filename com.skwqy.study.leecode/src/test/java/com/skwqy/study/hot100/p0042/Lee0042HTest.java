package com.skwqy.study.hot100.p0042;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-11 22:00
 */
public class Lee0042HTest {
    Lee0042H ins = new Lee0042H();

    @Test
    public void trap() {
        assertEquals(6, ins.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}