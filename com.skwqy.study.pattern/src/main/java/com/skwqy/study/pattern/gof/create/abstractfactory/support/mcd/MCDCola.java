package com.skwqy.study.pattern.gof.create.abstractfactory.support.mcd;

import com.skwqy.study.pattern.gof.create.abstractfactory.ICola;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MCDCola implements ICola
{
    private static final Log LOG = LogFactory.getLog(MCDCola.class);

    public void drink()
    {
        LOG.info("可可可乐，From：麦当劳");
    }

}
