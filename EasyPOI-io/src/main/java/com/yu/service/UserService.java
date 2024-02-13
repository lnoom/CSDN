package com.yu.service;

import com.yu.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    //批量保存
    void saveAll(List<User> users);
}
