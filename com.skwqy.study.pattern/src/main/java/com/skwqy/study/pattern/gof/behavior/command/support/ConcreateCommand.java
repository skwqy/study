package com.skwqy.study.pattern.gof.behavior.command.support;

import com.skwqy.study.pattern.gof.behavior.command.Command;
import com.skwqy.study.pattern.gof.behavior.command.Receiver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ConcreateCommand implements Command
{
    private static final Log LOG = LogFactory.getLog(ConcreateCommand.class);
    // 持有相应的接收者对象
    private final Receiver receive;

    public ConcreateCommand(Receiver receiverIn)
    {
        this.receive = receiverIn;
    }

    public void execute()
    {
        LOG.info("命令：将动作转接给接收值进行处理");
        receive.action();
    }

}
