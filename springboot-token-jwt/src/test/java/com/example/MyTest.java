package com.example;

import com.exmple.UserApplication;
import com.exmple.mapper.UserMapper;
import com.exmple.pojo.User;
import com.exmple.service.UserService;
import com.exmple.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = UserApplication.class)
public class MyTest {
    @Autowired
    UserService userService;
    @Test
    public void tesMapper(){
        User user = new User();
        user.setName("222");
        user.setPwd("333");
        System.out.println(userService.login(user));
    }

    @Test
    public void createToken()  {
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(),
                String.valueOf(2), null);
        System.out.println(token);
    }
    @Test
    public void parseJWT() throws Exception {
        Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzZjgzYzg5Zi02MzQ4LTQ4Y2YtODRhYS1jZjdkMjA4ZWNmNmMiLCJzdWIiOiIyIiwiaXNzIjoieXUiLCJpYXQiOjE3MDU0ODU4MzEsImV4cCI6MTcwNTQ4OTQzMX0.72HbnU6FEnJVWv7HUcui0Y44bnS95OB_OCs9GFSY55k");
        String subject = claims.getSubject();
        System.out.println(subject);
        System.out.println(claims);
    }
}