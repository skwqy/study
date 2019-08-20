package com.skwqy.study.leetcode.p0000.p0010;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 18:17
 */
public class Leet0026eTest {
    Leet0026e instance = new Leet0026e();
    @Test
    public void removeDuplicates() {
        int[] inputs = {1,1,2};
        int result = instance.removeDuplicates(inputs);
        assertEquals(2,result);
    }
}