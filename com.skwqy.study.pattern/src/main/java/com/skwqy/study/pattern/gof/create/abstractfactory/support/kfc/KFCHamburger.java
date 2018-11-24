package com.skwqy.study.pattern.gof.create.abstractfactory.support.kfc;

import com.skwqy.study.pattern.gof.create.abstractfactory.IHamburger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class KFCHamburger implements IHamburger
{
    private static final Log LOG = LogFactory.getLog(KFCHamburger.class);

    public void eat()
    {
        LOG.info("肯德基汉堡包，From：肯德基");
    }

}
