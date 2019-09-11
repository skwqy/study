package com.skwqy.study.hot100.p0200;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 22:28
 */
public class Lee0200MBFS2Test {

    Lee0200M_BFS2 ins = new Lee0200M_BFS2();

    @Test
    public void numIslands() {
        char[][] inputs = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0',
                '0'}, {'0', '0', '0', '0', '0'}};
        assertEquals(1, ins.numIslands(inputs));
    }

    @Test
    public void numIslands2() {
        char[][] inputs = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0',
                '0'}, {'0', '0', '0', '1', '1'}};
        assertEquals(3, ins.numIslands(inputs));
    }
}