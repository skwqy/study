package com.skwqy.study.hot100.p0621;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 15:38
 */
public class Lee0621MTest {
    Lee0621M ins = new Lee0621M();

    @Test
    public void leastInterval() {
        assertEquals(8,ins.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
}