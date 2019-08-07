package com.skwqy.study.oj.maze.ex01;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-07 21:35
 */
public class MazeTest {



    @Test
    public void testBfs() {
        char[][] maze = {{'#','S','#'},{'.','.','.'},{'G','.','#'}};
        Assert.assertEquals(3,Maze.bfs(maze));
    }
}