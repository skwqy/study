package com.skwqy.study.hot100.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 22:19
 */
public class Lee0200M_DFS {
    private static final int[][] POSITIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int r = 0, rLen = grid.length; r < rLen; r++) {
            for (int c = 0, cLen = grid[0].length; c < cLen; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    dfs(grid, r, c);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        if (r < 0 || r >= rLen || c < 0 || c >= cLen || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] position : POSITIONS) {
            int newR = r + position[0];
            int newC = c + position[1];
            dfs(grid, newR, newC);
        }
    }
}
