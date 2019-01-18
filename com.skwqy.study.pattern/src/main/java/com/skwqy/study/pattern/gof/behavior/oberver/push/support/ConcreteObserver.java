package com.skwqy.study.pattern.gof.behavior.oberver.push.support;

import com.skwqy.study.pattern.gof.behavior.oberver.push.Observer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConcreteObserver implements Observer
{
    private static final Log LOG = LogFactory.getLog(ConcreteObserver.class);
    // 观察者的状态
    private String observerState;

    @Override
    public void update(String state)
    {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        LOG.info("状态为：" + observerState);
    }

}