package com.skwqy.study.pattern.gof.behavior.strategy.support;

import com.skwqy.study.pattern.gof.behavior.strategy.IMemberStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class IntermediateMemberStrategy implements IMemberStrategy
{
    private static final Log LOG = LogFactory.getLog(IntermediateMemberStrategy.class);

    public double calcPrice(double booksPrice)
    {

        LOG.info("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }

}