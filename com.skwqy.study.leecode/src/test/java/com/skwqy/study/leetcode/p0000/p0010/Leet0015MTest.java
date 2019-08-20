package com.skwqy.study.leetcode.p0000.p0010;

import java.util.List;

import org.junit.Test;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 14:34
 */
public class Leet0015MTest {
    Leet0015m instans = new Leet0015m();

    @Test
    public void threeSum() {
        int[] inputs = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = instans.threeSum(inputs);
        for (List<Integer> result : lists) {
            for (int tmp : result) {
                System.out.println(tmp);
            }
        }
    }
}