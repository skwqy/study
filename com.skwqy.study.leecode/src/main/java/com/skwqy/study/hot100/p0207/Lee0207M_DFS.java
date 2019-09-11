package com.skwqy.study.hot100.p0207;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-07 23:01
 */
public class Lee0207M_DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }

        int[] flags = new int[numCourses];
        // 反向依赖
        int[][] rDepends = new int[numCourses][numCourses];
        for (int[] cp : prerequisites) {
            rDepends[cp[1]][cp[0]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(rDepends, flags, i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param rDepends 被依赖课程与课程之间的关系
     * @param flags    缓存标记，0：未被DFS访问，-1：已经被其它节点启动DFS访问过，无需再访问，1：正在被当前节点的DFS访问
     * @param i        课程编号，用来判断该课程依赖关系是否存在环
     * @return true：不存在环，false：存在环
     */
    private boolean dfs(int[][] rDepends, int[] flags, int i) {
        if (flags[i] == -1) {
            return true;
        }
        if (flags[i] == 1) {
            // 如果在dfs遍历中第二次访问，说明存在环
            return false;
        }

        flags[i] = 1;
        for (int j = 0; j < rDepends.length; j++) {
            if (rDepends[i][j] == 1 && !dfs(rDepends, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }
}
