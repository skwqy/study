package com.skwqy.study.spring.test.javaconfig.impl;

import com.skwqy.study.spring.test.javaconfig.IAccessNe;
import org.springframework.stereotype.Component;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:57 PM
 */
@Component
public class AccessNeImpl implements IAccessNe {
    @Override
    public String getNeInfo(String ip, String userName, String userPwd, int port) {
        return "product result";
    }
}
