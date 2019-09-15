package com.skwqy.study.hot100.p0017;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 22:59
 */
public class Lee0017M2Test {

    Lee0017M2 ins = new Lee0017M2();

    @Test
    public void letterCombinations() {
        List<String> strings = ins.letterCombinations("23");
        System.out.println(strings);
    }
}