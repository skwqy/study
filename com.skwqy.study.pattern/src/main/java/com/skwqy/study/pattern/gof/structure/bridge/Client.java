package com.skwqy.pattern.gof.structure.bridge;

import com.skwqy.study.pattern.gof.structure.bridge.IWindowImp;
import com.skwqy.study.pattern.gof.structure.bridge.support.IconWindow;
import com.skwqy.study.pattern.gof.structure.bridge.support.LinuxWindowImp;

/**
 * 将抽象部分与它的实现部分分离，使他们都可以独立地变化
 * 延伸：由多个以上的变化维度分离开来，通过管理类在组合不同维度的变化，从而防止类层次暴涨
 *
 * @author skwqy
 * @since 2016.03.12
 */
public class Client
{
    public static void main(String[] args)
    {
        IWindowImp winIpl = new LinuxWindowImp();
        IconWindow wind = new IconWindow(winIpl);
        wind.drawBorder();
    }

}
