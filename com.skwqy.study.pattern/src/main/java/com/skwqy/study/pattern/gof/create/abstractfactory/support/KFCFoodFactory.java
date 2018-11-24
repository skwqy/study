package com.skwqy.study.pattern.gof.create.abstractfactory.support;


import com.skwqy.study.pattern.gof.create.abstractfactory.IChicken;
import com.skwqy.study.pattern.gof.create.abstractfactory.ICola;
import com.skwqy.study.pattern.gof.create.abstractfactory.IFoodFactory;
import com.skwqy.study.pattern.gof.create.abstractfactory.IHamburger;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.kfc.KFCChicken;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.kfc.KFCCola;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.kfc.KFCHamburger;

public class KFCFoodFactory implements IFoodFactory
{

    public ICola getCola()
    {
        return new KFCCola();
    }

    public IChicken getChicken()
    {
        return new KFCChicken();
    }

    public IHamburger getHamburger()
    {
        return new KFCHamburger();
    }

}
