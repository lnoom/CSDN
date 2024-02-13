package com.yu.test;


import com.yu.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EasyPoiTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() {
        System.out.println(userMapper.findAll());
    }

}
