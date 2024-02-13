package com.yu;

import com.yu.dao.UserDao;
import com.yu.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-04 11:53
 */
public class SpringTest {
    public static void main(String[] args) {
        //创建容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        UserService userService = (UserService) app.getBean("userService");
        userService.showUser(); //展示用户数据
    }
}
