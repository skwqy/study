package com.skwqy.study.hot100.p0739;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 09:55
 */
public class Lee0739MTest {
    Lee0739M ins = new Lee0739M();

    @Test
    public void dailyTemperatures() {
        int[] inputs = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expect = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expect, ins.dailyTemperatures(inputs));
    }
}