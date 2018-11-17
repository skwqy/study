package com.skwqy.study.spring.test.javaconfig.impl;

import com.skwqy.study.spring.test.javaconfig.ILoadConfig;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 2:54 PM
 */
@Component
public class LoadConfigImpl implements ILoadConfig {
    @Override
    public Map<String, String> loadConfig() {
        Map<String,String> config = new HashMap<>();
        config.put("key","value");
        return config;
    }
}
