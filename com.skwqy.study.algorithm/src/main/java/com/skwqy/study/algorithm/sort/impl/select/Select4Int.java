package com.skwqy.study.algorithm.sort.impl.select;

import com.skwqy.study.algorithm.sort.IIntSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/2 4:14 PM
 */
@Component
public class Select4Int implements IIntSort {
    private static final Logger LOG = LoggerFactory.getLogger(Select4Int.class);

    @Override
    public void sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }

        for (int i = 0,length = numbers.length; i<length-1;i++){
            int minIdex =i;
            for(int j = i+1;j<length;j++){
                if (numbers[minIdex] > numbers[j]){
                    minIdex = j;
                }
            }
            if (minIdex != i){
                int tmp = numbers[i];
                numbers[i] = numbers[minIdex];
                numbers[minIdex] = tmp;
            }
        }
    }
}
