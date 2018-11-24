package com.skwqy.study.pattern.gof.create.abstractfactory.support.mcd;

import com.skwqy.study.pattern.gof.create.abstractfactory.IHamburger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MCDHamburger implements IHamburger
{
    private static final Log LOG = LogFactory.getLog(MCDHamburger.class);

    public void eat()
    {
        LOG.info("麦辣鸡腿汉堡，From：麦当劳");
    }

}
