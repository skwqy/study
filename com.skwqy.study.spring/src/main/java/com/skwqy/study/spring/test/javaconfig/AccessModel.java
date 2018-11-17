package com.skwqy.study.spring.test.javaconfig;

import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:07 PM
 */
public class AccessModel {
    private String neIp;
    private String parentId;
    private String userName;
    private String userPwd;
    private int port;
    private Map<String,String> info = new HashMap<>();

    public String getNeIp() {
        return neIp;
    }

    public void setNeIp(String neIp) {
        this.neIp = neIp;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("neIp", neIp)
                .add("parentId", parentId)
                .add("userName", userName)
                .add("userPwd", userPwd)
                .add("port", port)
                .add("info", info)
                .toString();
    }
}
