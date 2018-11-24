package com.skwqy.study.jdk.xproxy.dproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/24 9:20 PM
 */
public class DynamicProxy implements InvocationHandler {
    private static Logger LOG = LoggerFactory.getLogger(DynamicProxy.class);
    // 目标对象
    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 目标对象执行前的代码植入
        LOG.info("before target object method excute.");

        Object result = method.invoke(target,args);

        // 目标对象方法执行后的代码植入
        LOG.info("after target object method excute.");
        return result;
    }

    public Object getProxy(){
        // 要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

}
