package com.example.demo.common.exception;

/**
 * @author jiwei.chen
 * @create 2018-10-16
 * @detail 受检异常
 */
public class CheckException extends RuntimeException {

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
