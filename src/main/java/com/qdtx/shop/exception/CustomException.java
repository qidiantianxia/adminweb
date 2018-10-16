package com.qdtx.shop.exception;

/**
 * Created by yn on 2018-10-16
 */
public class CustomException extends Exception {

    //异常信息
    private String message;

    public CustomException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}