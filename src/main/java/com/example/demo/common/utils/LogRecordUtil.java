package com.example.demo.common.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * GO: Log persist tool
 * Created By JiWei.Chen 2018-12-28
 */
@Component
public class LogRecordUtil {

    public static final String LOG_KEY = "log_persist";

    private static ThreadLocalUtil threadLocalUtil;

    private static LogRecordUtil logRecordUtil;

    @PostConstruct
    public void init() {
        logRecordUtil = this;
    }

    public static void setLog(Object t) {
        ThreadLocalUtil.set(LOG_KEY, t);
    }

    public static Object getLog() {
        if (null != ThreadLocalUtil.get(LOG_KEY)) {
            System.out.println("线程：" + Thread.currentThread().getName() + "正在输出日志");
            return ThreadLocalUtil.get(LOG_KEY);
        }
        return null;
    }

    public static void saveLog() {
        if (null != ThreadLocalUtil.get(LOG_KEY)) {
            System.out.println("线程：" + Thread.currentThread().getName() + "正在持久化日志，日志内容：" + ThreadLocalUtil.get(LOG_KEY));
            ThreadLocalUtil.remove(LOG_KEY);
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 8; i++) {
            executorService.execute(new UserLogin("lee" + i));
        }
        System.out.println("thread pool is shutdown：" + executorService.isShutdown());
        executorService.shutdown();
        System.out.println("thread pool is shutdown：" + executorService.isShutdown());
    }

    static class UserLogin implements Runnable {
        private String name;

        public UserLogin(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            LogRecordUtil.setLog(this.name);
            System.out.println("线程：" + Thread.currentThread().getName() + ",用户：" + this.name + "请求登陆");
            LogRecordUtil.saveLog();
        }
    }
}
