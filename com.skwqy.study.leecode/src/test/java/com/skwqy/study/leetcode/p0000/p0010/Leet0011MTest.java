package com.skwqy.study.leetcode.p0000.p0010;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 10:48
 */
public class Leet0011MTest {

    Leet0011m instance = new Leet0011m();
    @Test
    public void maxArea() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        assertEquals(49,instance.maxArea(height));
    }
}