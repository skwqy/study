package com.skwqy.study.hot100.p0438;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 20:00
 */
public class Lee0438ETest {
    Lee0438E ins = new Lee0438E();

    @Test
    public void findAnagrams() {
        List<Integer> anagrams = ins.findAnagrams("cbaebabacd", "abc");
        int[] result = new int[anagrams.size()];
        int index = 0;
        for (int value : anagrams) {
            result[index++] = value;
        }
        int[] expect = {0, 6};
        assertArrayEquals(expect, result);
    }
}