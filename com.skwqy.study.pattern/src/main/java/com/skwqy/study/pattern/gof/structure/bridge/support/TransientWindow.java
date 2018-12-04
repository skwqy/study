package com.skwqy.study.pattern.gof.structure.bridge.support;

import com.skwqy.study.pattern.gof.structure.bridge.Window;
import com.skwqy.study.pattern.gof.structure.bridge.IWindowImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 普通的窗口，每种平台类型的系统都会有这样的窗口
 *
 * @author skwqy
 * @since 2016年3月12日
 */
public class TransientWindow extends Window {
    private static final Log LOG = LogFactory.getLog(TransientWindow.class);

    public TransientWindow(IWindowImp winImpIn) {
        super(winImpIn);
    }

    public void drawCloseBox() {
        LOG.info("普通窗口：渲染开始.......");
        drawRect();
        LOG.info("普通窗口：渲染完成.......");
    }

}
