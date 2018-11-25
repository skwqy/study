package com.skwqy.study.jdk.xproxy.aop.xconfig;

/**
 * 切面类
 */
public class TimeHandler
{
    public void beforMethod()
    {
        System.out.println("AOP [ begin ] CurrentTime = " + System.currentTimeMillis());
    }

    public void afterMethod()
    {
        System.out.println("AOP [ end ] CurrentTime = " + System.currentTimeMillis());
    }
}