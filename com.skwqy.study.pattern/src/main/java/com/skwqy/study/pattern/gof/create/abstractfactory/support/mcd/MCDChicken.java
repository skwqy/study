package com.skwqy.study.pattern.gof.create.abstractfactory.support.mcd;

import com.skwqy.study.pattern.gof.create.abstractfactory.IChicken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MCDChicken implements IChicken
{
    private static final Log LOG = LogFactory.getLog(MCDChicken.class);

    public void eate()
    {
        LOG.info("麦辣鸡翅，From：麦当劳");
    }

}
