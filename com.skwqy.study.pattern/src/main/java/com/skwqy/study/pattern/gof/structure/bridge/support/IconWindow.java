package com.skwqy.study.pattern.gof.structure.bridge.support;

import com.skwqy.study.pattern.gof.structure.bridge.Window;
import com.skwqy.study.pattern.gof.structure.bridge.WindowImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 带有图片的窗口，每种平台类型的窗口都会有带图片的窗口
 *
 * @author skwqy
 * @since 2016年3月12日
 */
public class IconWindow extends Window
{
    private static final Log LOG = LogFactory.getLog(IconWindow.class);

    public IconWindow(WindowImp winImpIn)
    {
        super(winImpIn);
    }

    public void drawBorder()
    {
        LOG.info("图片背景窗口：渲染开始.......");
        drawRect();
        drawText();
        LOG.info("图片背景窗口：渲染完成.......");
    }
}
