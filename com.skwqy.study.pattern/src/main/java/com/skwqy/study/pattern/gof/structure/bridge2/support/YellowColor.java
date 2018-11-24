package com.skwqy.study.pattern.gof.structure.bridge2.support;

import com.skwqy.study.pattern.gof.structure.bridge2.IColor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class YellowColor implements IColor
{

    private static final Log LOG = LogFactory.getLog(BigBrush.class);

    public void drawColor()
    {
        LOG.info("着色：黄色");
    }

}
