package com.example.demo.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * @author jiwei.chen
 * @create 2018-10-16
 * @detail 校验工具类
 */
public class CheckUtil {

    private static MessageSource messageSource;

    ResourceBundleMessageSource resourceBundleMessageSource;

    public static void setMessageSource(MessageSource messageSource) {
        CheckUtil.messageSource = messageSource;
    }

    public static void fail(){
        System.out.println("fail方式：");
        try {
            throw new RuntimeException(messageSource.getMessage("123",new Object[]{},new Locale("")));
        }catch (Exception e){
            System.out.println("捕获异常");
        }
        System.out.println("fail结束：");
    }

    public boolean isNotEmpty(CharSequence cs){
        return !StringUtils.isEmpty(cs);
    }
}
