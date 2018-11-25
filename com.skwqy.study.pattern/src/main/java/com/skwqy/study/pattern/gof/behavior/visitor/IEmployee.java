package com.skwqy.study.pattern.gof.behavior.visitor;

public interface IEmployee {
    void accept(IDepartment handler);
}