package com.skwqy.study.pattern.gof.create.factorymethod.support;

import com.skwqy.study.pattern.gof.create.factorymethod.IHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PhoneHttpHandler implements IHandler
{
    private static final Log LOG = LogFactory.getLog(PhoneHttpHandler.class);

    public void handle()
    {
        LOG.info("this is Phone client, so we need PhoneHttpHandler do deal with this request.");
    }

}
