package com.example.demo;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        HttpClients.createDefault();
        HttpClient client = HttpClients.createDefault();
        char[] chars = new char[4];
        new String(chars,1,2);
        "".substring(1, 2);
    }

}
