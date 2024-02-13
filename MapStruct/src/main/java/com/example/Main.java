package com.example;

import com.example.mapper.MapStructMapper;
import com.example.pojo.Source;
import com.example.pojo.Target;

import java.util.Date;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-31 12:11
 */
//在代码中使用MapStructMapper.INSTANCE.sourceToTarget(source)方法将Source对象转换为Target对象。
public class Main {
    public static void main(String[] args) {
        Source source = new Source("666", "奇遇少年", "123456",new Date(),111.23234);
        Target target = MapStructMapper.INSTANCE.sourceToTarget(source);
        System.out.println(target.toString());
    }
}
