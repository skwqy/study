package com.skwqy.study.hot100.p0448;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 16:13
 */
public class Lee0448ETest {
    Lee0448E ins = new Lee0448E();

    @Test
    public void findDisappearedNumbers() {
        int[] inputs = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] expect = new int[]{5, 6};
        List<Integer> disappearedNumbers = ins.findDisappearedNumbers(inputs);
        int[] result = new int[disappearedNumbers.size()];
        int i = 0;
        for (int value : disappearedNumbers) {
            result[i++] = value;
        }
        assertArrayEquals(expect, result);
    }
}