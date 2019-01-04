package com.example.demo.common.bean;

import java.io.Serializable;

/**
 * @author:no
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -2349429960288924003L;

    public static final int FAILURE = -1;
    public static final int SUCCESS = 1;
    public static final int UN_AUTH = 0;

    private int code = SUCCESS;
    private String message = "success";

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data){
        super();
        this.data = data;
    }

    public ResultBean(Throwable e){
        super();
        this.message = e.toString();
        this.code = FAILURE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
