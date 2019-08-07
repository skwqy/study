package com.skwqy.study.oj.calculator.ex01;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-02 21:12
 */
public class CalculatorTest {

    @Test
    public void testFormatExp(){
        Assert.assertEquals("-2*-5",Calculator.formatExp(" -2 * -5"));
    }

    @Test
    public void testminus2Neg(){
        Assert.assertEquals("@2*@5",Calculator.minus2Neg(Calculator.formatExp(" -2 * -5")));
    }

    @Test
    public void testDoCalcWithoutBreackets(){
        Assert.assertEquals("10.0",Calculator.doCalcWithoutBreackets(Calculator.formatExp(" -2 * -5")));
    }

    @Test
    public void testDoCalcWithoutBreackets2(){
        Assert.assertEquals("-5.0",Calculator.doCalcWithoutBreackets(Calculator.formatExp(" -5")));
    }

    @Test
    public void testDoCalcWithBreackets(){
        Assert.assertEquals("4.0",Calculator.doCalcWithBreackets(Calculator.formatExp(" -2 * (-5+3)")));
    }


    @Test
    public void testDoCalcWithBreackets2(){
        Assert.assertEquals("-2.0",Calculator.doCalcWithBreackets(Calculator.formatExp("MIN( -2 , (5+3))")));
    }

}