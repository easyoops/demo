package com.example.demo.common.exception;

/**
 * @author jiwei.chen
 * @create 2018-10-16
 * @detail 未登陆异常
 */
public class NotLoginException extends RuntimeException {

    public NotLoginException() {

    }

    public NotLoginException(String msg) {
        super(msg);
    }

    public NotLoginException(String msg, Throwable e) {
        super(msg, e);
    }
}
