package com.skwqy.study.pattern.gof.behavior.visitor;

/**
 * Element：
 * 1、元素层次变换不频繁，层次关系比较固定。
 * 2、可能存在不同的外部对象对元素进行访问：针对外部访问(visitor)变换比较频繁，
 *    （1）、抽象出一个接口IDepartment来封装访问者的变换。
 *    （2）、在IEmployee元素抽象中开一个方法来与变换抽象IDepartment来对接
 *
 * 解决方案解决的本质问题：
 * 1、支持visitor变化，可以随意增加visitor实现
 * 2、Elment元素保持固定，新增任何一种元素都会增加剧烈震荡。
 */
public interface IEmployee {
    /**
     * 所有访问者入口函数，主要起到转接作用
     * @param handler visitor对象
     */
    void accept(IDepartment handler);
}