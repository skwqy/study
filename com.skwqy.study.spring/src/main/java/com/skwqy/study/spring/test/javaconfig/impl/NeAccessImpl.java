package com.skwqy.study.spring.test.javaconfig.impl;

import com.skwqy.study.spring.test.javaconfig.IAccessNe;
import com.skwqy.study.spring.test.javaconfig.ILoadConfig;
import com.skwqy.study.spring.test.javaconfig.INeAccess;
import com.skwqy.study.spring.test.javaconfig.ISave2Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:17 PM
 */
@Service
public class NeAccessImpl implements INeAccess {

    @Autowired
    private ISave2Db save2Db;

    @Autowired
    private ILoadConfig loadConfig;

    @Autowired
    private IAccessNe accessNe;


    @Override
    public void access() {
        System.out.println("loadConfig = "+loadConfig.getClass().getName());
        System.out.println("accessNe = "+accessNe.getClass().getName());
        System.out.println("save2Db = "+save2Db.getClass().getName());
        System.out.println("Ne access Successful");
    }
}
