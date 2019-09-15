package com.skwqy.study.hot100.p0213;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-15 10:52
 */
public class Lee0070ETest {
    Lee0070E ins = new Lee0070E();

    @Test
    public void climbStairs2() {
        assertEquals(2, ins.climbStairs(2));
    }

    @Test
    public void climbStairs3() {
        assertEquals(3, ins.climbStairs(3));
    }

    @Test
    public void climbStairs4() {
        assertEquals(5, ins.climbStairs(4));
    }
}