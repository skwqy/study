package com.skwqy.study.hot100.p0213;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-15 10:48
 */
public class Lee0070E_DG {

    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return climb(0, n);
    }

    private int climb(int current, int n) {
        if (current > n) {
            return 0;
        }
        if (current == n) {
            return 1;
        }
        if (memo[current] > 0) {
            return memo[current];
        }

        memo[current] = climb(current + 1, n) + climb(current + 2, n);
        return memo[current];
    }
}
