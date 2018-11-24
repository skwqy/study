package com.skwqy.study.pattern.gof.create.abstractfactory;

public interface IFoodFactory
{
    ICola getCola();

    IChicken getChicken();

    IHamburger getHamburger();
}
