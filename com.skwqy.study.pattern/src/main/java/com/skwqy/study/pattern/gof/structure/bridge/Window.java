package com.skwqy.study.pattern.gof.structure.bridge;

/**
 * 窗口类
 *
 * @author skwqy
 * @since 2016年3月12日
 */
public abstract class Window
{
    protected WindowImp winImp;

    public Window(WindowImp winImpIn)
    {
        winImp = winImpIn;
    }

    public void drawText()
    {
        winImp.drawText();
    }

    public void drawRect()
    {
        for (int i = 0; i < 4; i++)
        {
            winImp.drawLine();
        }
    }
}
