package com.example.demo.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jiwei.chen
 * @create 2018-10-16
 * @detail 启动注入
 */
@Component
public class StaticInjection {

    @Autowired
    MessageSource messageSource;

    @PostConstruct
    public void init(){
        System.out.println("启动自动注入");
        CheckUtil.setMessageSource(messageSource);
        CheckUtil.fail();
    }
}
