package com.skwqy.study.pattern.gof.behavior.visitor.impl;

import com.skwqy.study.pattern.gof.behavior.visitor.IDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HRDepartment implements IDepartment {
    private static Logger LOG = LoggerFactory.getLogger(HRDepartment.class);

    // 实现人力资源部对兼职员工数据的访问
    @Override
    public void visit(PartTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        LOG.info("临时工 {} 实际工作时间为：{} 小时", employee.getName(), workTime);
    }

    // 实现人力资源部对全职员工数据的访问
    @Override
    public void visit(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        LOG.info("正式员工 {} 实际工作时间为：{} 小时", employee.getName(), workTime);

        if (workTime > 40) {
            LOG.info("正式员工 {} 加班时间为：{} 小时", employee.getName(), workTime - 40);
        } else if (workTime < 40) {
            LOG.info("正式员工 {} 请假时间为：{} 小时", employee.getName(), 40 - workTime);
        }
    }
}