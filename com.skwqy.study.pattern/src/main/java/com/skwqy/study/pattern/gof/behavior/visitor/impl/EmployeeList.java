package com.skwqy.study.pattern.gof.behavior.visitor.impl;

import com.skwqy.study.pattern.gof.behavior.visitor.IDepartment;
import com.skwqy.study.pattern.gof.behavior.visitor.IEmployee;

import java.util.LinkedList;
import java.util.List;

public class EmployeeList {
    // 员工集合
    private List<IEmployee> empList = new LinkedList<IEmployee>();

    public void addEmployee(IEmployee emp) {
        this.empList.add(emp);
    }

    // 处理员工数据
    public void accept(IDepartment handler) {
        for(IEmployee emp : empList)
        {
            emp.accept(handler);
        }
    }
}