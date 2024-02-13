package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;


@SpringBootTest
public class DruidTest {
    @Autowired
    private DataSource dataSource;

    @Test
    void test(){
        System.out.println(dataSource.getClass());
    }
}
