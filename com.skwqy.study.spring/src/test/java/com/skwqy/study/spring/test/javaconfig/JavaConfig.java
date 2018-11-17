package com.skwqy.study.spring.test.javaconfig;

import com.skwqy.study.spring.test.javaconfig.impl.LoadConfigImpl;
import com.skwqy.study.spring.test.javaconfig.impl.NeAccessImpl;
import com.skwqy.study.spring.test.javaconfig.mock.AccessNeStub;
import com.skwqy.study.spring.test.javaconfig.mock.Save2DbStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 3:34 PM
 */
@Configuration
public class JavaConfig {
    @Bean
    public INeAccess neAccessImpl(){
        return new NeAccessImpl();
    }

    @Bean
    public ILoadConfig loadConfig(){
        return  new LoadConfigImpl();
    }

    @Bean
    public ISave2Db save2DbStub(){
        return new Save2DbStub();
    }

    @Bean
    public IAccessNe accessNeStub(){
        return new AccessNeStub();
    }
}
