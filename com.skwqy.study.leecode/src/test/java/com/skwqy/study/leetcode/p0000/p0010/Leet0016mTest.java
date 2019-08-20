package com.skwqy.study.leetcode.p0000.p0010;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 15:24
 */
public class Leet0016mTest {
    Leet0016m instance = new Leet0016m();

    @Test
    public void threeSumClosest() {
        int[] inputs = {-1, 2, 1, -4};
        int target = 1;
        assertEquals(2, instance.threeSumClosest(inputs, target));
    }

    @Test
    public void threeSumClosest2() {
        int[] inputs = {1, 1, 1, 0};
        int target = 100;
        assertEquals(3, instance.threeSumClosest(inputs, target));
    }

    @Test
    public void threeSumClosest4() {
        String str = "()";
        str=str.substring(0,0);
        System.out.println("str="+str);
    }
}