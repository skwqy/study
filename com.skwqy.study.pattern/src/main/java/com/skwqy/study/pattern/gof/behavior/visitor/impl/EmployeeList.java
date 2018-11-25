package com.skwqy.study.pattern.gof.behavior.visitor.impl;

import com.skwqy.study.pattern.gof.behavior.visitor.IDepartment;
import com.skwqy.study.pattern.gof.behavior.visitor.IEmployee;

import java.util.LinkedList;
import java.util.List;

public class EmployeeList {
    private List<IEmployee> empList = new LinkedList<IEmployee>();

    public void addEmployee(IEmployee emp) {
        this.empList.add(emp);
    }

    public void accept(IDepartment handler) {
        for(IEmployee emp : empList)
        {
            emp.accept(handler);
        }
    }
}