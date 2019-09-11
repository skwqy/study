package com.skwqy.study.leetcode.p0400;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-28 22:22
 */
public class Leet0406MTest {
    Leet0406M ins =new Leet0406M();
    @Test
    public void reconstructQueue() {
        int[][] inputs ={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = ins.reconstructQueue(inputs);
        System.out.println(Arrays.deepToString(result));
    }
}