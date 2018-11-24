package com.skwqy.study.pattern.gof.create.factorymethod.support;

import com.skwqy.study.pattern.gof.create.factorymethod.IHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NullHttpHandler implements IHandler
{
    private static final Log LOG = LogFactory.getLog(NullHttpHandler.class);

    public void handle()
    {
        LOG.info("this is not a valid client, please check this request come from.");
    }

}
