package com.skwqy.study.leetcode.p0200.p0226e;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-20 23:44
 */
public class Leet0239HTest {
    Leet0239H instance = new Leet0239H();

    @Test
    public void maxSlidingWindow() {
        int[] inputs = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = instance.maxSlidingWindow(inputs, 3);
        int[] expect = {3, 3, 5, 5, 6, 7};
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expect,result);
    }
}