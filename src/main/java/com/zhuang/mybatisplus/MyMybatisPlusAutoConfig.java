package com.zhuang.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.zhuang.mybatisplus.*.mapper")
@ComponentScan
public class MyMybatisPlusAutoConfig {

}
