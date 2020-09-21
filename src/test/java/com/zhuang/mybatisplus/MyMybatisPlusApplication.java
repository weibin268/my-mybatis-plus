package com.zhuang.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class MyMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMybatisPlusApplication.class, args);
    }

}
