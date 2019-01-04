package com.example.demo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-18
 */
@Configuration
public class JedisPoolUtil {

    @Autowired
    private RedisCons redisCons;

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(config, redisCons.getHost(), redisCons.getPort());
        return jedisPool;
    }
}
