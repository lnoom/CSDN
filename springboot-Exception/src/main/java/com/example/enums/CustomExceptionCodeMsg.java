package com.example.enums;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-20 17:53
 */
public enum CustomExceptionCodeMsg {
    INVALID_CODE(0000, "验证码无效"),
    USERNAME_NOT_EXISTS(11111, "用户名不存在");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    CustomExceptionCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
