package com.yu.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.domain.User;
import com.yu.mapper.UserMapper;
import com.yu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{
}
