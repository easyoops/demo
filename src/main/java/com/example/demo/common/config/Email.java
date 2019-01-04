package com.example.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-13
 */
@Configuration
public class Email {

    @Value("${email.from}")
    private String from;

    @Value("${email.to}")
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
