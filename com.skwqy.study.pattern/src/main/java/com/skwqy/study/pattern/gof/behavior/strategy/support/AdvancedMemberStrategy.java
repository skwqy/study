package com.skwqy.study.pattern.gof.behavior.strategy.support;

import com.skwqy.study.pattern.gof.behavior.strategy.IMemberStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AdvancedMemberStrategy implements IMemberStrategy
{
    private static final Log LOG = LogFactory.getLog(AdvancedMemberStrategy.class);

    public double calcPrice(double booksPrice)
    {
        LOG.info("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}