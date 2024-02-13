/*
 * Copyright (c) 2020, 2024,  All rights reserved.
 *
 */
package com.example.exception;
 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * <p>Project: springboot - GlobalException</p>
 * <p>Powered by scl On 2024-01-15 10:11:29</p>
 * <p>描述：<p>
 *
 * @author 孙臣龙 [1846080280@qq.com]
 * @version 1.0
 * @since 17
 */
@Component
public class GlobalException implements HandlerExceptionResolver {
 
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
//        if (e instanceof NullPointerException){
//            modelAndView.setViewName("error");
//        }
            modelAndView.setViewName("error");
        modelAndView.addObject("msg",e.toString());
        return modelAndView;
    }
}