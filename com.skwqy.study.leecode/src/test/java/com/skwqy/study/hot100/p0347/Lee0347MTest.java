package com.skwqy.study.hot100.p0347;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-12 23:19
 */
public class Lee0347MTest {
    Lee0347M ins = new Lee0347M();

    @Test
    public void topKFrequent() {
        int[] inputs = new int[]{1, 1, 1, 2, 2, 3};
        int[] expect = new int[]{1, 2};
        System.out.println(ins.topKFrequent(inputs, 2));
    }
}