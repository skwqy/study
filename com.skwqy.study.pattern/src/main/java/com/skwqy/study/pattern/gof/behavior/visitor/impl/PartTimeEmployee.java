package com.skwqy.study.pattern.gof.behavior.visitor.impl;

import com.skwqy.study.pattern.gof.behavior.visitor.IDepartment;
import com.skwqy.study.pattern.gof.behavior.visitor.IEmployee;

public class PartTimeEmployee implements IEmployee {
    private String name;

    private double hourWage;

    private int workTime;

    public PartTimeEmployee(String name, double hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(IDepartment handler) {
        handler.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}