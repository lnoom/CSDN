package com.example.test;

import com.yu.service.YuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-08 11:22
 */
@SpringBootTest
public class YuStarterTest {
    @Autowired
    private YuService yuService;
    @Test
    public void test() {
       yuService.yu();
    }
}
