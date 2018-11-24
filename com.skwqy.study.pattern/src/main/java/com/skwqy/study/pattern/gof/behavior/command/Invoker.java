package com.skwqy.study.pattern.gof.behavior.command;

/**
 * 请求者
 *
 * @author skwqy
 *
 */
public class Invoker
{
    /**
     * 持有命令对象
     */
    private Command command = null;

    public Invoker(Command command)
    {
        this.command = command;
    }

    /**
     * 行动方法
     */
    public void action()
    {

        command.execute();
    }
}
