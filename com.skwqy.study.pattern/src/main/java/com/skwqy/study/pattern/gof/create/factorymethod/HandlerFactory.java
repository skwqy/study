package com.skwqy.study.pattern.gof.create.factorymethod;

import com.skwqy.study.pattern.gof.create.factorymethod.support.NullHttpHandler;
import com.skwqy.study.pattern.gof.create.factorymethod.support.PCHttpHandler;
import com.skwqy.study.pattern.gof.create.factorymethod.support.PhoneHttpHandler;

public class HandlerFactory
{
    public static IHandler getHandler(int type)
    {
        if (type == 0)
        {
            return new PCHttpHandler();
        }
        else if (type == 1)
        {
            return new PhoneHttpHandler();
        }
        else
        {
            return new NullHttpHandler();
        }
    }
}
