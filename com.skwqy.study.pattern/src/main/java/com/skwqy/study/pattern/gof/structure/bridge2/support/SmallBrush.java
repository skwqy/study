package com.skwqy.study.pattern.gof.structure.bridge2.support;

import com.skwqy.study.pattern.gof.structure.bridge2.Brush;
import com.skwqy.study.pattern.gof.structure.bridge2.IColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallBrush extends Brush {
    private static final Logger LOG = LoggerFactory.getLogger(SmallBrush.class);

    public SmallBrush(IColor colorIn) {
        super(colorIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void drawLine() {
        LOG.info("绘画直线：开始渲染......");
        LOG.info("绘画直线：细线条");
        drawColor();
        LOG.info("绘画直线：渲染结束......");
    }
}
