package com.skwqy.study.hot100.p0739;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 10:22
 */
public class Lee0739M2Test {

    Lee0739M2 ins = new Lee0739M2();

    @Test
    public void dailyTemperatures() {
        int[] inputs = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expect = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expect, ins.dailyTemperatures(inputs));
    }
}