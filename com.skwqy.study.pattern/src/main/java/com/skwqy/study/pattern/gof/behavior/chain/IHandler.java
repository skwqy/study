package com.skwqy.study.pattern.gof.behavior.chain;

public interface IHandler
{
    void setBoss(IHandler boss);

    void dealApply(Request request);
}
