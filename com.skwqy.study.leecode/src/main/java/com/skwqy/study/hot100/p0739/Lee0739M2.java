package com.skwqy.study.hot100.p0739;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 09:52
 */
public class Lee0739M2 {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int delay = 0;
            for (int j = i + 1; j < temperatures.length; j += result[j]) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
