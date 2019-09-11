package com.skwqy.study.leetcode.p0200.p0226e;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-01 17:09
 */
public class Lee0227MTest {
    Lee0227M ins = new Lee0227M();

    @Test
    public void calculate() {
        assertEquals(7, ins.calculate("3+2*2"));
    }

    @Test
    public void calculate1() {
        assertEquals(1, ins.calculate(" 3/2 "));
    }

    @Test
    public void calculate2() {
        assertEquals(5931, ins.calculate("10994+617-5680"));
    }


}