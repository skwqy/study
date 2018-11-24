package com.skwqy.pattern.gof.behavior.command;

import com.skwqy.study.pattern.gof.behavior.command.Command;
import com.skwqy.study.pattern.gof.behavior.command.Invoker;
import com.skwqy.study.pattern.gof.behavior.command.Receiver;
import com.skwqy.study.pattern.gof.behavior.command.support.ConcreateCommand;

/**
 * 命令模式主要目的：将请求对象(Invoker) 和 接受者(Receiver) 解耦
 *
 * @author skwqy
 * @since 2016.03.11
 */
public class Client
{
    public static void main(String[] args)
    {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令对象，设定它的接收者
        Command command = new ConcreateCommand(receiver);
        // 创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);
        // 执行方法
        invoker.action();
    }
}
