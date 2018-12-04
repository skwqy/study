package com.skwqy.study.pattern.gof.structure.bridge.support;

import com.skwqy.study.pattern.gof.structure.bridge.IWindowImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 苹果系统：在渲染窗口时，需要怎么去实现，每种平台实现的方式都不同
 *
 * @author skwqy
 * @since 2016年3月12日
 */
public class MacWindowImp implements IWindowImp {
    private static final Log LOG = LogFactory.getLog(MacWindowImp.class);

    @Override
    public int drawText() {
        LOG.info("苹果平台：绘制背景图");
        return 0;
    }

    @Override
    public void drawLine() {
        LOG.info("苹果平台：绘制直线");
    }

}
