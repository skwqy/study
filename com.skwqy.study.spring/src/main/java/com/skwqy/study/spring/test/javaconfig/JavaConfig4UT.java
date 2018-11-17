package com.skwqy.study.spring.test.javaconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 在对产品代码做UT时，往往需要对DB访问、网络访问的接口进行stub替换
 * 如果使用Spring XML文件配置bean，则每个接口都需要有个set方法，我们进行stub替换时，只需要调用set接口设置stub即可。
 * 如果使用Spring 注解进行Bean组装时，我们可以通过JavaConfig方式在限定组装bean的范围
 *
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:00 PM
 */
public class JavaConfig4UT {
    private static final String JAVA_CLASS_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/spring.xml");
        INeAccess neAccess = applicationContext.getBean(INeAccess.class);
        neAccess.access();
        if (neAccess == null )
        {
            System.out.println("is null ");
        }
    }
}
