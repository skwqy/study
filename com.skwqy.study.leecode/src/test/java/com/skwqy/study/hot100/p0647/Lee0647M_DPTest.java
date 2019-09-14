package com.skwqy.study.hot100.p0647;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 13:57
 */
public class Lee0647M_DPTest {
    Lee0647M_DP ins = new Lee0647M_DP();

    @Test
    public void countSubstrings() {
        assertEquals(3, ins.countSubstrings("abc"));
    }

    @Test
    public void countSubstrings2() {
        assertEquals(6, ins.countSubstrings("aaa"));
    }
}