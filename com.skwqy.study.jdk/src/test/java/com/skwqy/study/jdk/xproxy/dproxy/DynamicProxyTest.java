package com.skwqy.study.jdk.xproxy.dproxy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 动态代理采用组合的方式，能够代理任何类，包括final类型的类
 * 存在的缺陷：被代理的对象必须是实现一定的接口才行
 *
 * cglib采用继承的方式，解决没有实现接口的类，但是如果类使用final修饰时，仍然无法代理
 *
 * @author skwqy
 * @Created on 2018 11 2018/11/24 9:27 PM
 */
public class DynamicProxyTest {

    @Test
    public void testHello(){
        HelloWord helloWord = new HelloWord();
        DynamicProxy dynamicProxy = new DynamicProxy(helloWord);
        IHello hello = (IHello) dynamicProxy.getProxy();
        hello.sayHello("skwqy");
    }

}