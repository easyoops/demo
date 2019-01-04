package com.example.demo.common.utils;




import org.slf4j.MDC;

import java.util.Locale;

/**
 * @author jiwei.chen
 * @create 2018-10-16
 * @detail 用户util
 */
public class UserUtil {

    public static final String KEY_USER = "user";
    public static final String KEY_lOCALE = "locale";

    private static final ThreadLocal<String> localUser = new ThreadLocal<>();

    private static final ThreadLocal<Locale> localLocale = new ThreadLocal<Locale>() {
        @Override
        protected Locale initialValue() {
            return Locale.CHINESE;
        }
    };

    /**
     * set登陆信息
     *
     * @param userId
     */
    public static void setLocalUser(String userId) {
        localUser.set(userId);
        //用户信息设置到logger
        MDC.put(KEY_USER, userId);
    }

    /**
     * 如果没有登陆 返回null
     *
     * @return
     */
    public static String getUserIfLogin() {
        return localUser.get();
    }

    /**
     * 获取登陆信息(抛出未登陆异常)
     *
     * @return
     */
    public static String getUser() {
        String userId = localUser.get();
        if (userId == null) {
            throw new RuntimeException("not login");
        }
        return userId;
    }

    public static void setLocale(String locale) {
        Locale lang = new Locale(locale);
        localLocale.set(lang);
    }

    public static Locale getLocale() {
        return localLocale.get();
    }

    public static void clearUserInfo() {
        localLocale.remove();
        localUser.remove();

        MDC.remove(KEY_USER);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Run("jack"));
        t1.setName("jack");
        Thread t2 = new Thread(new Run("lee"));
        t2.setName("lee");
        t1.start();
        t2.start();
    }
}
