package com.example.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    private String datePattern;

    public StringToDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String source) {
        try {
            return new SimpleDateFormat(datePattern).parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式。请使用这个模式\"" + datePattern + "\"");
        }
    }
}