package com.skwqy.study.spring.test.javaconfig.mock;

import com.skwqy.study.spring.test.javaconfig.IAccessNe;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 3:32 PM
 */
public class AccessNeStub implements IAccessNe {
    @Override
    public String getNeInfo(String ip, String userName, String userPwd, int port) {
        return "Mock info";
    }
}
