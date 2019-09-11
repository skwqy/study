package com.skwqy.study.hot100.p0200;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 22:35
 */
public class Lee0200M_DFSTest {

    Lee0200M_DFS ins = new Lee0200M_DFS();

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