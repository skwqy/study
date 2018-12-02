package com.skwqy.study.spring.test.javaconfig.impl;

import com.skwqy.study.spring.test.javaconfig.IAccessStep;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/2 5:19 PM
 */
@Order(3)
@Component
public class ThirdStep implements IAccessStep {
    @Override
    public void access() {

    }
}
