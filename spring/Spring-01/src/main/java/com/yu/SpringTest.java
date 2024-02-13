package com.yu;

import com.yu.pojo.Hello;
import com.yu.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-03 15:05
 */
public class SpringTest {
    public static void main(String[] args) {
        //解析beans.xml文件 , 生成管理相应的Bean对象
        //创建Spring容器，指定要读取的配置文件路径
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean : 参数即为spring配置文件中bean的id .
        //从容器中获取对象
        User user = (User) context.getBean("user");
        //调用对象的方法进行测试
        System.out.println(user.toString());
    }
}
