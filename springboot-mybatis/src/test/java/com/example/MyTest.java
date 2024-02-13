package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest(classes = UserApplication.class)
public class MyTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private DataSource dataSource;
    @Test
    public void tesMapper(){
        System.out.println(userMapper.findAll());
    }
    @Test
    void test(){
        System.out.println(dataSource.getClass());
    }



    @Test
    void test1(){
        DruidDataSource dataSource = (DruidDataSource) this.dataSource;
        System.out.println("最大连接数："+dataSource.getMaxActive());
        System.out.println("初始化连接数："+dataSource.getInitialSize());
    }
}