package com.skwqy.study.hot100.p0560;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 10:06
 */
public class Lee0560MTest {
    Lee0560M ins = new Lee0560M();

    @Test
    public void subarraySum() {
        assertEquals(2, ins.subarraySum(new int[]{1, 1, 1}, 2));
    }
}