package com.skwqy.study.pattern.gof.create.abstractfactory.support.kfc;

import com.skwqy.study.pattern.gof.create.abstractfactory.IChicken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class KFCChicken implements IChicken
{
    private static final Log LOG = LogFactory.getLog(KFCChicken.class);

    public void eate()
    {
        LOG.info("奥尔良烤翅，From：肯德基");
    }

}
