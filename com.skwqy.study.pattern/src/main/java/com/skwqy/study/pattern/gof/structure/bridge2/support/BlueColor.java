package com.skwqy.study.pattern.gof.structure.bridge2.support;

import com.skwqy.study.pattern.gof.structure.bridge2.IColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlueColor implements IColor
{

    private static final Logger LOG = LoggerFactory.getLogger(BigBrush.class);

    public void drawColor()
    {
        LOG.info("着色：蓝色");
    }

}
