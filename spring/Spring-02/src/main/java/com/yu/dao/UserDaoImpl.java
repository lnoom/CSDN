package com.yu.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-04 11:49
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void showUser() {
        System.out.println("展示用户数据");
    }
}
