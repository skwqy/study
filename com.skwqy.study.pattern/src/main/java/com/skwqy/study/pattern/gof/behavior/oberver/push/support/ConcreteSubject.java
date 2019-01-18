package com.skwqy.study.pattern.gof.behavior.oberver.push.support;

import com.skwqy.study.pattern.gof.behavior.oberver.push.Subject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConcreteSubject extends Subject
{
    private static final Log LOG = LogFactory.getLog(ConcreteSubject.class);
    private String state;

    public String getState()
    {
        return state;
    }

    public void change(String newState)
    {
        state = newState;
        LOG.info("主题状态为：" + state);
        // 状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}