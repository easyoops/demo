package com.example.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-18
 */
@Configuration
public class RedisCons {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
