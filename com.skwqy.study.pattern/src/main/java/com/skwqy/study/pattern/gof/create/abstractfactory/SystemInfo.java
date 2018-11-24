package com.skwqy.study.pattern.gof.create.abstractfactory;

import com.skwqy.study.pattern.gof.create.abstractfactory.support.KFCFoodFactory;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.MCDFoodFactory;

public class SystemInfo
{
    public static IFoodFactory getFoodFactory()
    {
        String type = System.getProperty("IFoodFacory", "KFC");
        if ("KFC".equals(type))
        {
            return new KFCFoodFactory();
        }
        return new MCDFoodFactory();
    }
}
