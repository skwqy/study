package com.skwqy.study.spring.test.javaconfig.impl;

import com.skwqy.study.spring.test.javaconfig.IAccessNe;
import com.skwqy.study.spring.test.javaconfig.ILoadConfig;
import com.skwqy.study.spring.test.javaconfig.INeAccess;
import com.skwqy.study.spring.test.javaconfig.ISave2Db;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:17 PM
 */
@Service
public class NeAccessImpl implements INeAccess {
    private static Logger LOG = LoggerFactory.getLogger(NeAccessImpl.class);
    @Autowired
    private ISave2Db save2Db;

    @Autowired
    private ILoadConfig loadConfig;

    @Autowired
    private IAccessNe accessNe;


    @Override
    public void access() {
        LOG.info("loadConfig = {}",loadConfig.getClass().getName());
        LOG.info("accessNe = {}", accessNe.getClass().getName());
        LOG.info("save2Db = {}", save2Db.getClass().getName());
        LOG.info("Ne access Successful");
    }
}
