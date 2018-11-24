package com.skwqy.study.pattern.gof.structure.bridge.support;

import com.skwqy.study.pattern.gof.structure.bridge.WindowImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LinuxWindowImp extends WindowImp
{
    private static final Log LOG = LogFactory.getLog(LinuxWindowImp.class);

    @Override
    public int drawText()
    {
        LOG.info("Linux平台：绘制背景图");
        return 0;
    }

    @Override
    public void drawLine()
    {
        LOG.info("Linux平台：绘制直线");
    }

}
