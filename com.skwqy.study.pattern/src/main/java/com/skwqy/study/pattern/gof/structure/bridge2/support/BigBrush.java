package com.skwqy.study.pattern.gof.structure.bridge2.support;

import com.skwqy.study.pattern.gof.structure.bridge2.Brush;
import com.skwqy.study.pattern.gof.structure.bridge2.IColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigBrush extends Brush
{
    public BigBrush(IColor colorIn)
    {
        super(colorIn);
    }

    private static final Logger LOG = LoggerFactory.getLogger(BigBrush.class);

    @Override
    public void drawLine()
    {
        LOG.info("绘画直线：开始渲染......");
        LOG.info("绘画直线：粗线条");
        color.drawColor();
        LOG.info("绘画直线：渲染结束......");
    }

}
