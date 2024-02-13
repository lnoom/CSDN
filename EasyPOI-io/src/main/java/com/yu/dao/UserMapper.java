package com.yu.dao;

import com.yu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有
    List<User> findAll();
    //插入记录
    void save(User user);
}
