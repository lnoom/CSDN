package com.yu.service;

import com.yu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-04 11:46
 */
@Service("userService")
public class UserDaoImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Value("666")
    private int total;
    @Value("奇遇少年")
    private String name;
    @Value("#{22+1}")
    private Integer age;
    public void showUser() {
        System.err.println(total+name+age);
        userDao.showUser();
    }
}
