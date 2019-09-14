package com.skwqy.study.hot100.p0739;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-13 09:52
 */
public class Lee0739M {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int delay = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    delay = j - i;
                    break;
                }
            }
            result[i] = delay;
        }

        return result;
    }
}
