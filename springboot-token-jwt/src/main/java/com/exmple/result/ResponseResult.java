package com.exmple.result;


public class ResponseResult {
    private String code;
    private String msg;
    private Object data;

    private ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult() {
    }

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setCode("200");
        result.setMsg("请求成功");
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = success();
        result.setData(data);
        return result;
    }

    public static ResponseResult error() {
        ResponseResult result = new ResponseResult();
        result.setCode("500");
        result.setMsg("请求失败");
        return result;
    }

    public static ResponseResult error(String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode("500");
        result.setMsg(msg);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
