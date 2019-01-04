package com.example.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-29
 */
@Configuration
public class RSAConf {

    @Value("${rsa.privateKey}")
    private String privateKey;

    @Value("${rsa.publicKey}")
    private String publicKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
