package com.skwqy.study.pattern.gof.behavior.chain.support;

import com.skwqy.study.pattern.gof.behavior.chain.IHandler;
import com.skwqy.study.pattern.gof.behavior.chain.Request;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CEOManager implements IHandler
{

    private static final Log LOG = LogFactory.getLog(CEOManager.class);
    private IHandler boss;

    public void setBoss(IHandler boss)
    {
        this.boss = boss;
    }

    public void dealApply(Request request)
    {
        if (request.getAmount() < 100000)
        {
            LOG.info("Approve：amount = " + request.getAmount());
        }
        else if (boss != null)
        {
            boss.dealApply(request);
        }
        else
        {
            LOG.info("Nobody can deal with this apply. amount = " + request.getAmount());
        }
    }

}
