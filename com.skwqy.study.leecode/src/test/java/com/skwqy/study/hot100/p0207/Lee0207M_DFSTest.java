package com.skwqy.study.hot100.p0207;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 11:06
 */
public class Lee0207M_DFSTest {

    Lee0207M_DFS ins = new Lee0207M_DFS();

    @Test
    public void canFinish() {
        assertTrue(ins.canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    public void canFinish2() {
        assertFalse(ins.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void canFinish3() {
        assertTrue(ins.canFinish(3, new int[][]{{1, 0}, {2, 0}}));
    }
}