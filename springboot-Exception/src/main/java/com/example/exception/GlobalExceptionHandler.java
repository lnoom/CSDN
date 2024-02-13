package com.example.exception;

import com.example.result.Resp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages="com.example.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> Resp<T> exceptionHandler(Exception e){
        //这里先判断拦截到的Exception是不是我们自定义的异常类型
        if(e instanceof CustomException){
            CustomException customException = (CustomException)e;
            return Resp.error(customException.getCode(),customException.getMsg());
        }

        //如果拦截的异常不是我们自定义的异常(例如：数据库主键冲突)
        return Resp.error(500,"服务器端异常");
    }
}