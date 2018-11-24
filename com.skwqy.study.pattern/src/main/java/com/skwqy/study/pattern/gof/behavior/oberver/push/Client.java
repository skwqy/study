package com.skwqy.study.pattern.gof.behavior.oberver.push;

import com.skwqy.study.pattern.gof.behavior.oberver.push.Observer;
import com.skwqy.study.pattern.gof.behavior.oberver.push.support.ConcreteObserver;
import com.skwqy.study.pattern.gof.behavior.oberver.push.support.ConcreteSubject;

/**
 * 观察者：定义对象间的一种一对多的依赖关系，当一个对象的状态发生变化时，所有依赖它的对象都得到通知并自动更新
 * 推模式
 *
 * @author skwqy
 * @since 2016年3月13日
 */
public class Client
{
    public static void main(String[] args)
    {
        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者对象
        Observer observer = new ConcreteObserver();
        // 将观察者对象登记到主题对象上
        subject.attach(observer);
        // 改变主题对象的状态
        subject.change("new state");
    }

}
