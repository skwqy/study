package com.skwqy.study.pattern.gof.behavior.visitor.impl;


import com.skwqy.study.pattern.gof.behavior.visitor.IDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinanceDepartment implements IDepartment {
    private static Logger LOG = LoggerFactory.getLogger(FinanceDepartment.class);
    // 实现财务部对兼职员工数据的访问
    @Override
    public void visit(PartTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        LOG.info("临时工 {} 实际工资为：{} 元", employee.getName(), workTime * hourWage);
    }

    // 实现财务部对全职员工数据的访问
    @Override
    public void visit(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weekWage = employee.getWeeklyWage();

        if (workTime > 40) {
            weekWage = weekWage + (workTime - 40) * 50;
        } else if (workTime < 40) {
            weekWage = weekWage - (40 - workTime) * 80;
            if (weekWage < 0) {
                weekWage = 0;
            }
        }

        LOG.info("正式员工 {} 实际工资为：{} 元", employee.getName(), weekWage);
    }
}