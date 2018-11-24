package com.skwqy.study.jdk.xproxy.cglib;

import com.skwqy.study.jdk.xproxy.dproxy.DynamicProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/24 9:34 PM
 */
public class CglibProxy implements MethodInterceptor {
    private static Logger LOG = LoggerFactory.getLogger(DynamicProxy.class);

    private Object target;

    public CglibProxy(Object target){
        this.target = target;
    }

    /**
     * 创建代理对象
     *
     * @return
     */
    public Object getProxy() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    // 回调方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        // 目标对象执行前的代码植入
        LOG.info("before target object method excute.");

        Object result = proxy.invokeSuper(obj, args);

        // 目标对象方法执行后的代码植入
        LOG.info("after target object method excute.");
        return result;
    }

}
