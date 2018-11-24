package com.skwqy.study.pattern.gof.structure.bridge2;

import com.skwqy.study.pattern.gof.structure.bridge2.support.BigBrush;
import com.skwqy.study.pattern.gof.structure.bridge2.support.RedColor;

/**
 * 将抽象部分与它的实现部分分离，使他们都可以独立地变化
 * 延伸：由多个以上的变化维度分离开来，通过管理类在组合不同维度的变化，从而防止类层次暴涨
 * 如果只有二个变化的维度，那么这个管理类可以退化到一个变化的维度中来兼职担当
 *
 * @author skwqy
 * @since 2016年3月13日
 */
public class Client
{

    public static void main(String[] args)
    {
        IColor color = new RedColor();
        Brush brush = new BigBrush(color);
        brush.drawLine();
    }

}
