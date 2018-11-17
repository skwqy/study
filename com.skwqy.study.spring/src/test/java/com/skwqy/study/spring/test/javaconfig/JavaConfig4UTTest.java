package com.skwqy.study.spring.test.javaconfig;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 3:20 PM
 */
public class JavaConfig4UTTest {
    ApplicationContext appContext = null;

    @Before
    public void setUp(){
        appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @Test
    public void testAccess(){
        INeAccess neAccess = appContext.getBean(INeAccess.class);
        neAccess.access();
    }
}