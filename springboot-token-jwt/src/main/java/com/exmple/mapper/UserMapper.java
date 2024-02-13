package com.exmple.mapper;

import com.exmple.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User login(User user);
}

