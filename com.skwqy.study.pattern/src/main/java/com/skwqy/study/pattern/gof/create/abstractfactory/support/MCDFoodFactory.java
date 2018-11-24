package com.skwqy.study.pattern.gof.create.abstractfactory.support;


import com.skwqy.study.pattern.gof.create.abstractfactory.IChicken;
import com.skwqy.study.pattern.gof.create.abstractfactory.ICola;
import com.skwqy.study.pattern.gof.create.abstractfactory.IFoodFactory;
import com.skwqy.study.pattern.gof.create.abstractfactory.IHamburger;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.mcd.MCDChicken;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.mcd.MCDCola;
import com.skwqy.study.pattern.gof.create.abstractfactory.support.mcd.MCDHamburger;

public class MCDFoodFactory implements IFoodFactory
{

    public ICola getCola()
    {
        return new MCDCola();
    }

    public IChicken getChicken()
    {
        return new MCDChicken();
    }

    public IHamburger getHamburger()
    {
        return new MCDHamburger();
    }

}
