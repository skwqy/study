package com.skwqy.study.hot100.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 22:19
 */
public class Lee0200M_BFS {
    private static final int[][] POSITIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0, rLen = grid.length; r < rLen; r++) {
            for (int c = 0, cLen = grid[0].length; c < cLen; c++) {
                if (grid[r][c] == '1') {
                    if (bfs(r, c, grid, visited)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean bfs(int r, int c, char[][] grid, boolean[][] visited) {
        boolean visit = false;
        int rLen = grid.length;
        int cLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            if (!visited[point[0]][point[1]]) {
                visited[point[0]][point[1]] = true;
                visit = true;
            }
            for (int[] position : POSITIONS) {
                int newR = point[0] + position[0];
                int newC = point[1] + position[1];
                if (newR >= 0 && newR < rLen && newC >= 0 && newC < cLen && grid[newR][newC] == '1') {
                    if (!visited[newR][newC]) {
                        visit = true;
                        visited[newR][newC] = true;
                        queue.add(new int[] {newR, newC});
                    }
                }
            }
        }
        return visit;
    }
}
