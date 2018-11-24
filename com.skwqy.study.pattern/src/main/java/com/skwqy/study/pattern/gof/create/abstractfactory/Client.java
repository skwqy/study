package com.skwqy.study.pattern.gof.create.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client
{
    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args)
    {

        System.setProperty("IFoodFacory", "KFC");
        IFoodFactory foodFactory = SystemInfo.getFoodFactory();
        IChicken chicken = foodFactory.getChicken();
        chicken.eate();
        ICola cola = foodFactory.getCola();
        cola.drink();
        IHamburger hamberger = foodFactory.getHamburger();
        hamberger.eat();

        LOG.info("-----------------------------------------------------------");
        System.setProperty("IFoodFacory", "MCD");
        foodFactory = SystemInfo.getFoodFactory();
        chicken = foodFactory.getChicken();
        chicken.eate();
        cola = foodFactory.getCola();
        cola.drink();
        hamberger = foodFactory.getHamburger();
        hamberger.eat();
    }

}
