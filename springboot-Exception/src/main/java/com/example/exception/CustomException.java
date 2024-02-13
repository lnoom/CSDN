package com.example.exception;

import com.example.enums.CustomExceptionCodeMsg;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-20 17:55
 */
public class CustomException extends RuntimeException {

    private int code = 500;
    private String msg = "服务器异常";


    public CustomException(CustomExceptionCodeMsg customExceptionCodeMsg) {
        super();
        this.code = customExceptionCodeMsg.getCode();
        this.msg = customExceptionCodeMsg.getMsg();

    }

    public CustomException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;

    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}