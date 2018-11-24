package com.skwqy.study.pattern.gof.behavior.chain;

import com.skwqy.study.pattern.gof.behavior.chain.support.CEOManager;
import com.skwqy.study.pattern.gof.behavior.chain.support.PDTManager;
import com.skwqy.study.pattern.gof.behavior.chain.support.SPDTManager;

/**
 * 使多个对象有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些接受对象连成一条链，并沿着这条链传递该请求
 * 直到有一个对象处理它为止（请求的发送者不直接引用响应它的对象，这使得系统在不影响客户端的情况下动态的重新组织和分配职责）
 *
 * @author skwqy
 * @since 2016年3月13日
 */
public class Cilent
{
    public static void main(String[] args)
    {
        IHandler bigBoss = new CEOManager();
        IHandler spdtManager = new SPDTManager();
        spdtManager.setBoss(bigBoss);
        IHandler pdtManager = new PDTManager();
        pdtManager.setBoss(spdtManager);

        // 报销申请单，对于员工来说，并不直到最终处理报销单的是何人，只需要将报销请求提交给他的PDT经理即可
        Request request = new Request();
        request.setAmount(2000);
        pdtManager.dealApply(request);

        request.setAmount(6000);
        pdtManager.dealApply(request);

        request.setAmount(16000);
        pdtManager.dealApply(request);

        request.setAmount(1600000);
        pdtManager.dealApply(request);
    }
}
