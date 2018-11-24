package com.skwqy.study.pattern.gof.behavior.oberver.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Subject
{
    private static final Logger LOG = LoggerFactory.getLogger(Subject.class);
    /**
     * 用来保存注册的观察者对象
     */
    private final List<Observer> list = new CopyOnWriteArrayList<Observer>();

    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(Observer observer)
    {

        list.add(observer);
        LOG.info("Attached an observer");
    }

    /**
     * 删除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(Observer observer)
    {

        list.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void nodifyObservers(String newState)
    {

        for (Observer observer : list)
        {
            observer.update(newState);
        }
    }
}