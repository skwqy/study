package com.skwqy.pattern.gof.create.factorymethod;

public class Main
{
    public static void main(String[] args)
    {
        // PropertyConfigurator.configure("D:/work_j2ee/com.skwqy.study/log4j.properties");
        IHandler handler = HandlerFactory.getHandler(0);
        handler.handle();
    }
}
