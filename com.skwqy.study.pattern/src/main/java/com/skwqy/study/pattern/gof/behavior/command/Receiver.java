package com.skwqy.study.pattern.gof.behavior.command;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver
{
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    public void action()
    {
        LOG.info("接受者：执行动作");
    }
}
