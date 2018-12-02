package com.skwqy.study.algorithm.sort.impl.bubble;

import com.skwqy.study.algorithm.sort.IIntSort;
import com.skwqy.study.algorithm.sort.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/2 4:14 PM
 */
@Component("bubble4Int")
public class Bubble4Int implements IIntSort {
    private static final Logger LOG = LoggerFactory.getLogger(Bubble4Int.class);

    @Override
    public void sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }

        int length = numbers.length;
        boolean hasSorted = false;
        for (int index = length - 1; index > 0 && !hasSorted; index--) {
            hasSorted = true;
            for (int j = 0; j < index; j++) {
                if (numbers[j + 1] < numbers[j]) {
                    hasSorted = false;
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
                LOG.info(StrUtil.getArrayStr(numbers));
            }
            //LOG.info(StrUtil.getArrayStr(numbers));
        }
    }
}
