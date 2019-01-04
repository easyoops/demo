package com.example.demo.common.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-13
 */
@Controller
public class Task {

    private final AtomicInteger atomic = new AtomicInteger();

    @Scheduled(cron = "* 1 * * * ?")
    public void test() {
        int tmp = atomic.intValue();
        System.out.println("------------------atomic:" + tmp + ",condition：" + tmp % 2);
        if (tmp % 2 == 0) {
            System.out.println(LocalDateTime.now());
        } else {
            System.out.println("no print...");
        }
        atomic.incrementAndGet();
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException("123");
        } catch (Exception e) {
            System.out.println("catch：" + e);
        }
        System.out.println("end");
    }
}
