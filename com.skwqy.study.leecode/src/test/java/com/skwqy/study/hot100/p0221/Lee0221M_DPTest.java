package com.skwqy.study.hot100.p0221;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-08 15:12
 */
public class Lee0221M_DPTest {

    Lee0221M_DP ins = new Lee0221M_DP();

    @Test
    public void maximalSquare() {
        assertEquals(4, ins.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}
                , {'1', '0', '1', '1', '1'}
                , {'1', '1', '1', '1', '1'}
                , {'1', '0', '0', '1', '0'}
        }));
    }

    @Test
    public void maximalSquare2() {
        assertEquals(1, ins.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}
                , {'1', '0', '1', '1', '1'}
                , {'1', '1', '1', '0', '1'}
                , {'1', '0', '0', '1', '0'}
        }));
    }
}