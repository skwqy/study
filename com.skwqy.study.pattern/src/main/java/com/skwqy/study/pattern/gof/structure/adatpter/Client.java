package com.skwqy.pattern.gof.structure.adatpter;

import com.skwqy.study.pattern.gof.structure.adatpter.Adaptee;
import com.skwqy.study.pattern.gof.structure.adatpter.Adapter;
import com.skwqy.study.pattern.gof.structure.adatpter.Target;

/**
 * 将一个类的接口转换成用户希望的另外一个接口
 *
 * @author skwqy
 * @since 2016.03.11
 */
public class Client
{
    public static void main(String[] args)
    {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
