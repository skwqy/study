package com.skwqy.study.spring.test.javaconfig;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author skwqy
 * @Since 2018 11 2018/11/17 3:20 PM
 */
public class JavaConfig4UtTest {
    private  static Logger LOG = LoggerFactory.getLogger(JavaConfig4UtTest.class);
    ApplicationContext appContext = null;

    @Before
    public void setUp(){
        // 此处初始化调用次数和本类中测试用例的个数相同。
        LOG.info("init appContext.");
        appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @Test
    public void testAccess(){
        INeAccess neAccess = appContext.getBean(INeAccess.class);
        neAccess.access();
    }

    @Test
    public void testOther(){

    }
}