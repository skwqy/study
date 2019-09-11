package com.skwqy.study.hot100.p0046;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-11 23:28
 */
public class Lee0046MTest {
    Lee0046M ins = new Lee0046M();

    @Test
    public void permute() {
        List<List<Integer>> permute = ins.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}