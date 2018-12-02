package com.skwqy.study.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/2 4:40 PM
 */
public final class StrUtil {
    private static final Logger LOG = LoggerFactory.getLogger(StrUtil.class);

    public static String getArrayStr(int[] numbers){
        if (numbers == null){
            return "";
        }
        StringBuilder sb = new StringBuilder(3*numbers.length);
        for (int index=0,length = numbers.length;index < length;index++){
            sb.append(numbers[index]).append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
