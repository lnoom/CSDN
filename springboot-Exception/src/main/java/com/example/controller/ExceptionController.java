package com.example.controller;

import com.example.enums.CustomExceptionCodeMsg;
import com.example.exception.CustomException;
import com.example.result.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-20 17:58
 */
@RestController
public class ExceptionController {
    @GetMapping("/exception")
    public Resp<String> exception(String name) {

        if ("ok".equals(name)) {
            return Resp.success("成功");
        }
        if ("err".equals(name)) {
            //抛业务相关的异常
            throw new CustomException(CustomExceptionCodeMsg.USERNAME_NOT_EXISTS);
        }

        if ("errcode".equals(name)) {
            throw new CustomException(CustomExceptionCodeMsg.INVALID_CODE);
        }
        if ("0".equals(name)) {
            int i = 1 / 0;
        }

        return Resp.success("default");
    }

    @GetMapping("/list")
    public Resp<List> list() {
        List<String> list = Arrays.asList("CSDN", "奇遇少年");

        return Resp.success(list);
    }
}
