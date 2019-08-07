package com.skwqy.study.oj.maze.ex01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String t = sc.nextLine();

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            map[i] = s.toCharArray();
        }
        System.out.println(bfs(map));

    }

    public static int bfs(char[][] map) {
        int[] begin = getLocation(map, 'S');
        int[] end = getLocation(map, 'G');

        //移动的四个方向
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] d = getPathMark(map);

        //储存未进行处理的点
        Queue<int[]> que = new LinkedList<int[]>();
        //将起始点放入队列
        que.offer(begin);
        //将起始点最短路径设为0
        d[begin[0]][begin[1]] = 0;
        //一直循环直到队列为空
        while (!que.isEmpty()) {
            //取出队列中最前端的点
            int[] current = que.poll();
            //如果是终点则结束
            if (current[0] == end[0] && current[1] == end[1]) break;
            //四个方向循环
            for (int i = 0; i < 4; i++) {
                //试探
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                //判断是否可以走
                if (ny >= 0 && ny < d.length
                        && nx >= 0 && nx < d[0].length
                        && map[ny][nx] != '#'
                        && d[ny][nx] == Integer.MAX_VALUE) {
                    //如果可以走，则将该点的距离加1
                    d[ny][nx] = d[current[0]][current[1]] + 1;
                    //并将该点放入队列等待下次处理
                    int[] c = {ny, nx};
                    que.offer(c);
                }
            }
        }
        return d[end[0]][end[1]];
    }

    private static int[][] getPathMark(char[][] map) {
        //用来储存距离到起始点最短路径的二维数组
        int[][] d = new int[map.length][map[0].length];

        //将所有的位置都初始化为最大
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        return d;
    }

    private static int[] getLocation(char[][] map, char targetChar) {
        int[] result = new int[2];
        for (int i = 0, len = map.length; i < len; i++) {
            for (int j = 0, jLen = map[0].length; j < jLen; j++) {
                if (map[i][j] == targetChar) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}