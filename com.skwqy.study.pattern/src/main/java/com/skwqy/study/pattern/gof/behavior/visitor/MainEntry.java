package com.skwqy.study.pattern.gof.behavior.visitor;

import com.skwqy.study.pattern.gof.behavior.visitor.impl.*;

/**
 * 访问者（Visitor）模式：提供一个作用于某对象结构中的各元素的操作表示，
 * 它使得可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 *
 * 优点：
 * 1、增加新的访问操作十分方便，不痛不痒 => 符合开闭原则
 * 2、将有关元素对象的访问行为集中到一个访问者对象中，而不是分散在一个个的元素类中，
 *    类的职责更加清晰 => 符合单一职责原则
 *
 * 缺点：
 * 1、增加新的元素类很困难，需要在每一个访问者类中增加相应访问操作代码 => 违背了开闭原则
 * 2、元素对象有时候必须暴露一些自己的内部操作和状态，否则无法供访问者访问 => 破坏了元素的封装性
 *
 * 应用场景：
 * 1、一个对象结构包含多个类型的对象，希望对这些对象实施一些依赖其具体类型的操作。=> 不同的类型可以有不同的访问操作
 * 2、对象结构中对象对应的类很少改变 很少改变 很少改变（重要的事情说三遍），但经常需要在此对象结构上定义新的操作。
 *
 */
public class MainEntry {
    public static void main(String[] args) {
        EmployeeList empList = new EmployeeList();
        IEmployee fteA = new FullTimeEmployee("梁思成", 3200.00, 45);
        IEmployee fteB = new FullTimeEmployee("徐志摩", 2000, 40);
        IEmployee fteC = new FullTimeEmployee("梁徽因", 2400, 38);
        IEmployee fteD = new PartTimeEmployee("方鸿渐", 80, 20);
        IEmployee fteE = new PartTimeEmployee("唐宛如", 60, 18);

        empList.addEmployee(fteA);
        empList.addEmployee(fteB);
        empList.addEmployee(fteC);
        empList.addEmployee(fteD);
        empList.addEmployee(fteE);

        IDepartment finance = new FinanceDepartment();
        IDepartment hr = new HRDepartment();

        empList.accept(finance);
        empList.accept(hr);
    }
}