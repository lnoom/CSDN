package com.yu.config;

import com.yu.service.YuService;
import com.yu.service.YuServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class YuStarterAutoConfiguration {
    // 配置相关的bean和组件

    @Bean
    public YuService yuService() {
        return new YuServiceImpl();
    }
}