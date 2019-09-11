package com.skwqy.study.hot100.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 22:19
 */
public class Lee0200M_BFS2 {
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
                    bfs(r, c, grid);
                }
            }
        }
        return ans;
    }

    private void bfs(int r, int c, char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            for (int[] position : POSITIONS) {
                int newR = point[0] + position[0];
                int newC = point[1] + position[1];
                if (newR >= 0 && newR < rLen && newC >= 0 && newC < cLen && grid[newR][newC] == '1') {
                    grid[newR][newC] = '0';
                    queue.add(new int[]{newR, newC});
                }
            }
        }
    }
}
