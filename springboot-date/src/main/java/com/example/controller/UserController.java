package com.example.controller;

import com.example.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-03 9:56
 */
@RestController
public class UserController {
    @GetMapping("/list")
    public List userList(){
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("奇遇少年",new Date(),new Date(),new Date()));
        return userList;
    }

    @GetMapping("/user")
    public String getUser(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date userDate) {
        System.out.println(userDate);
        // 处理逻辑
        return  userDate.toString();
    }

    @GetMapping("/test")
    public String testMethod(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date testdate){
        System.out.println(testdate);
        return testdate.toString();
    }
}
