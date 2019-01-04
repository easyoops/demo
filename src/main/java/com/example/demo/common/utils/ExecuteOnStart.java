package com.example.demo.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ExecuteOnStart {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageSource messageSource;

    @PostConstruct
    public void start(){
        logger.info("@PostConstruct[MessageSource]:{}",messageSource.toString());
        CheckUtil.setMessageSource(messageSource);
        CheckUtil.fail();
    }
}
