package com.skwqy.study.pattern.gof.behavior.oberver.push;

public interface Observer
{
    /**
     * 更新接口
     * 
     * @param state 更新的状态
     */
    void update(String state);
}