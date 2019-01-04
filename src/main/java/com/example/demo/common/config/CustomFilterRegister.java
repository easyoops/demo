package com.example.demo.common.config;

import com.example.demo.common.filter.IPFilter;
import com.example.demo.common.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiwei.chen
 * @create 2018-11-06
 * @detail 自定义过滤器配置
 */
@Configuration
public class CustomFilterRegister {

    @Bean
    public FilterRegistrationBean securityRegister() {
        FilterRegistrationBean register = new FilterRegistrationBean();
        //注入过滤器
        register.setFilter(new UserFilter());
        //规则
        register.addUrlPatterns("/*");
        //名称
        register.setName("UserFilter");
        //顺序
        register.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE-2);
        return register;
    }

    @Bean
    public FilterRegistrationBean addressFilter() {
        FilterRegistrationBean register = new FilterRegistrationBean();
        //1.name
        register.setName("addressFilter");
        //2.class
        register.setFilter(new IPFilter());
        //3.urls pattern
        register.addUrlPatterns("/*");
        //4.order
        register.setOrder(RegistrationBean.LOWEST_PRECEDENCE - 1);
        return register;
    }

}
