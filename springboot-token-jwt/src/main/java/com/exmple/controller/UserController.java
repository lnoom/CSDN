package com.exmple.controller;

import com.exmple.pojo.User;
import com.exmple.result.ResponseResult;
import com.exmple.service.UserService;
import com.exmple.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
//校验用户名密码是否正确
        User loginUser = userService.login(user);
        Map<String, Object> map;
        if (loginUser != null) {

            //如果正确 生成token返回
            map = new HashMap<>();
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(),
                    String.valueOf(loginUser.getId()), null);
            map.put("token", token);
        } else {
//如果不正确 给出相应的提示
            return ResponseResult.error("用户名或密码错误，请重新登录");
        }
        return  ResponseResult.success(map);
    }

}