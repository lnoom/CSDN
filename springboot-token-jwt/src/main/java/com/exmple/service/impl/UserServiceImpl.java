package com.exmple.service.impl;

import com.exmple.mapper.UserMapper;
import com.exmple.pojo.User;
import com.exmple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;
    @Override
    public User login(User user) {
        User loginUser = UserMapper.login(user);
        return loginUser;
    }
}
