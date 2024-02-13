/*
 * Copyright (c) 2020, 2024,  All rights reserved.
 *
 */
package com.example.exception;

import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class AjaxGlobalException {

    @ResponseBody
    @ExceptionHandler
    public Map errorHandler(Exception e) {

        Map<String, Object> m = new HashMap<>();
        m.put("status", 500);
        m.put("msg", e.toString());

        return m;
    }
}