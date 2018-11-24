package com.skwqy.study.pattern.gof.behavior.strategy;

/**
 * 抽象折扣类
 *
 * @author skwqy
 * @since 2016年3月13日
 */
public interface IMemberStrategy
{
    /**
     * 计算图书的价格
     * 
     * @param booksPrice 图书的原价
     * @return 计算出打折后的价格
     */
    double calcPrice(double booksPrice);
}
