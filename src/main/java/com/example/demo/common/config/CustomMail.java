package com.example.demo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-13
 */
@Component
@PropertySource(value = "classpath:customer.properties")
@ConfigurationProperties(value = "cus.email")
public class CustomMail {

    private String from;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
