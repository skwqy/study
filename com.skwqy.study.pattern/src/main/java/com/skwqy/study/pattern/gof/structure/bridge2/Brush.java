package com.skwqy.study.pattern.gof.structure.bridge2;

/**
 * 笔刷，笔刷变化的维度按照其刷后的效果可以分为：粗笔刷、细笔刷
 *
 * @author skwqy
 * @since 2016年3月13日
 */
public abstract class Brush
{
    protected IColor color;

    public Brush(IColor colorIn)
    {
        color = colorIn;
    }

    protected void drawColor()
    {
        color.drawColor();
    }

    public abstract void drawLine();
}
