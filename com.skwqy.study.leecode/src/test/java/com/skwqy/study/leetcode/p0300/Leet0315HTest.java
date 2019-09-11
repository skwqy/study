package com.skwqy.study.leetcode.p0300;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-28 22:59
 */
public class Leet0315HTest {
    Leet0315H ins = new Leet0315H();

    @Test
    public void countSmaller() {
        int[] inputs = {5, 2, 6, 1};
        List<Integer> result = ins.countSmaller(inputs);
        System.out.println(result);
    }
}