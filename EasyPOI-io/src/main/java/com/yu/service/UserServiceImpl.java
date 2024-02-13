package com.yu.service;

import com.yu.dao.UserMapper;
import com.yu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void saveAll(List<User> users) {
        users.forEach(user -> {
            user.setId(null);
            user.setPhoto(user.getPhoto().substring(user.getPhoto().lastIndexOf("\\") + 1));
            System.out.println(user.getPhoto());
            userMapper.save(user);
        });
    }
}
