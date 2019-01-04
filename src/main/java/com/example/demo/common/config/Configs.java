package com.example.demo.common.config;

import com.example.demo.domain.SysUserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiwei.chen
 * @create 2018-10-16
 * @detail 配置类
 */
@Configuration
public class Configs {

    @Bean
    public SysUserBean createPerson(){
        SysUserBean userBean = new SysUserBean();
        userBean.setEmail("jiwei.chen@lanmaoly.com");
        return userBean;
    }
}
