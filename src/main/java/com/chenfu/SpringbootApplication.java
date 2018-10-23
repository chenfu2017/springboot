package com.chenfu;

import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages="com.chenfu.mapper")
// 扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
public class SpringbootApplication {
    @Bean
    public SpringUtil getSpingUtil() {
        return new SpringUtil();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
