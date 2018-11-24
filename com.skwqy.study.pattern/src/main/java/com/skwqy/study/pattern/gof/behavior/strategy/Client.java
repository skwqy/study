package com.skwqy.pattern.gof.behavior.strategy;

import com.skwqy.study.pattern.gof.behavior.strategy.IMemberStrategy;
import com.skwqy.study.pattern.gof.behavior.strategy.Price;
import com.skwqy.study.pattern.gof.behavior.strategy.support.AdvancedMemberStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 策略模式：定义一系列算法，把它们封装起来，并且可以互相替换。使得算法可独立于使用它的客户而变化</br>
 * 优点：
 * <ol>
 * <li>相关算法系列：Strategy类层次为Context定义了一系列可重用的算法或行为。继承有助于提取出算法中的公共功能</li>
 * <li>消除条件判断：不同行为堆砌在一个类中，难免需要条件判断，将行为封装为一个个独立的Strategy类消除了这些条件语句
 * </ol>
 * 缺点：
 * <ol>
 * <li>客户端熟悉算法族：客户必须知道所有的策略类（理解每种算法的区别），并决定使用哪一个策略类。</li>
 * <li>策略类数量膨胀：如果备选策略很多的话，将会产生很多数量的策略类</li>
 * <li>Strategy与Context间通信开销：Strategy与Price，Price将算法计算委托给策略类去进行，增加了间接层，增加了开销</
 * li>
 * </ol>
 *
 * @author skwqy
 * @since 2016年3月13日
 */
public class Client
{
    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args)
    {
        // 选择并创建需要使用的策略对象
        IMemberStrategy strategy = new AdvancedMemberStrategy();
        // 创建环境
        Price price = new Price(strategy);
        // 计算价格
        double quote = price.quote(300);
        LOG.info("图书的最终价格为：" + quote);
    }
}
