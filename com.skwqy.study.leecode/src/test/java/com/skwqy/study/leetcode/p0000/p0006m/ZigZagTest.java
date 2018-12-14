package com.skwqy.study.leetcode.p0000.p0006m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/12 11:13 PM
 */
public class ZigZagTest {

    @Test
    public void convert() {
        ZigZag zigZag = new ZigZag();
        Assert.assertEquals(
                "PAHNAPLSIIGYIR",zigZag.convert("PAYPALISHIRING",3));
    }
}