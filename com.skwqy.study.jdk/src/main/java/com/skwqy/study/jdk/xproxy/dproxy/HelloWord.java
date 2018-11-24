package com.skwqy.study.jdk.xproxy.dproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/24 9:17 PM
 */
public class HelloWord implements IHello {
    private static Logger LOG = LoggerFactory.getLogger(HelloWord.class);
    @Override
    public void sayHello(String name) {
        LOG.info("hello {}, you can see the world.",name);
    }
}
