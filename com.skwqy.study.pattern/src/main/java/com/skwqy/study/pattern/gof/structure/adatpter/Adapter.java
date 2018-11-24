package com.skwqy.study.pattern.gof.structure.adatpter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adapter implements Target
{
    private static final Logger LOG = LoggerFactory.getLogger(Adapter.class);
    private final Adaptee adatptee;

    public Adapter(Adaptee adatpteeIn)
    {
        adatptee = adatpteeIn;
    }

    public void request()
    {
        LOG.info("Adapter : 用户希望的接口，将请求整理后，请老接口帮忙处理");
        adatptee.specificRequest();
    }

}
