package com.skwqy.study.hot100.p0017;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-14 22:50
 */
public class Lee0017MTest {
    Lee0017M ins = new Lee0017M();

    @Test
    public void letterCombinations() {
        List<String> strings = ins.letterCombinations("234");
        System.out.println(strings);
    }
}