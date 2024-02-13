package com.example.fastjson;

import com.alibaba.fastjson.JSON;
import com.example.pojo.User;

import java.util.Date;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-31 9:52
 */

public class FastJsonTest {
    public static void main(String[] args) {
        //创建对象
        User user = new User("奇遇少年", "666", new Date());
        //将对象转换为json字符串
        String toJSONString = JSON.toJSONString(user);
        System.out.println(toJSONString);
        //将json字符串转换为对象
        User json = JSON.parseObject(toJSONString, User.class);
        System.out.println(json);
    }
}
