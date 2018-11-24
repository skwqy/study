package com.skwqy.study.pattern.gof.structure.adatpter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adaptee
{
    private static final Logger LOG = LoggerFactory.getLogger(Adaptee.class);

    public void specificRequest()
    {
        LOG.info("Adataptee : 老接口，已经存在，真正干活的。");
    }
}
