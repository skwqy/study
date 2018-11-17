package com.skwqy.study.spring.test.javaconfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 8:13 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
//@ContextConfiguration(locations={"classpath:spring-config.xml"})//加载spring配置文件
@ContextConfiguration(classes = JavaConfig.class)
public class JavaConfig4UtNewTest {
    private  static Logger LOG = LoggerFactory.getLogger(JavaConfig4UtTest.class);

    @Autowired
    private INeAccess neAccess;

    @Test
    public void testAccess(){
        neAccess.access();
    }

    @Test
    public void testOther(){
        LOG.info("for new spring test");
    }
}
