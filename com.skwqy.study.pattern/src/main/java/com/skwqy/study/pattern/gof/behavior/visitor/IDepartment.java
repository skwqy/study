package com.skwqy.study.pattern.gof.behavior.visitor;

import com.skwqy.study.pattern.gof.behavior.visitor.impl.FullTimeEmployee;
import com.skwqy.study.pattern.gof.behavior.visitor.impl.PartTimeEmployee;

public interface IDepartment {
    // 声明一组重载的访问方法，用于访问不同类型的具体元素
    void visit(FullTimeEmployee employee);

    void visit(PartTimeEmployee employee);
}