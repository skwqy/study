package com.skwqy.study.pattern.gof.create.abstractfactory.support.kfc;

import com.skwqy.study.pattern.gof.create.abstractfactory.ICola;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class KFCCola implements ICola
{
    private static final Log LOG = LogFactory.getLog(KFCCola.class);

    public void drink()
    {
        LOG.info("百事可乐，From：肯德基");
    }

}
