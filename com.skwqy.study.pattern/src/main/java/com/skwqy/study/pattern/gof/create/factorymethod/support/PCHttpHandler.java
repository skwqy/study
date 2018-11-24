package com.skwqy.study.pattern.gof.create.factorymethod.support;

import com.skwqy.study.pattern.gof.create.factorymethod.IHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PCHttpHandler implements IHandler
{
    private static final Log LOG = LogFactory.getLog(PCHttpHandler.class);

    public void handle()
    {
        LOG.info("this is PC client, so we need PCHttpHandler do deal with this request.");
    }
}
