package com.skwqy.study.pattern.gof.behavior.strategy.support;

import com.skwqy.study.pattern.gof.behavior.strategy.IMemberStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class PrimaryMemberStrategy implements IMemberStrategy
{
    private static final Log LOG = LogFactory.getLog(PrimaryMemberStrategy.class);

    public double calcPrice(double booksPrice)
    {

        LOG.info("对于初级会员的没有折扣");
        return booksPrice;
    }

}