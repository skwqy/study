package com.skwqy.study.hot100.p0055;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-15 09:22
 */
public class Lee0055M_BTTest {

    Lee0055M_BT ins = new Lee0055M_BT();

    @Test
    public void canJump() {
        assertEquals(true, ins.canJump(new int[]{0}));
    }

    @Test
    public void canJump2() {
        assertEquals(true, ins.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void canJump3() {
        assertEquals(false, ins.canJump(new int[]{2, 0, 0, 1, 4}));
    }
}