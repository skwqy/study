package com.skwqy.study.spring.test.javaconfig.impl;

import com.skwqy.study.spring.test.javaconfig.AccessModel;
import com.skwqy.study.spring.test.javaconfig.ISave2Db;
import org.springframework.stereotype.Component;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:55 PM
 */
@Component
public class Save2DbImpl implements ISave2Db {
    @Override
    public void save(AccessModel accessModel) {
        System.out.println("Product save2Db.");
    }
}
