package com.skwqy.study.leetcode.p0900;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-01 20:41
 */
public class Lee0991MTest {
    Lee0991M ins = new Lee0991M();

    @Test
    public void brokenCalc() {
        assertEquals(2, ins.brokenCalc(2, 3));
    }

    @Test
    public void brokenCalc2() {
        assertEquals(2, ins.brokenCalc(5, 8));
    }

    @Test
    public void brokenCalc3() {
        assertEquals(3, ins.brokenCalc(3, 10));
    }

    @Test
    public void brokenCalc4() {
        assertEquals(1023, ins.brokenCalc(1024, 1));
    }

    @Test
    public void brokenCalc5() {
        assertEquals(39, ins.brokenCalc(1, 1000000000));
    }
}