package com.zhuang.mybatisplus.generator;

import org.junit.Test;

public class CodeGeneratorTest {

    @Test
    public void generate() {
        new CodeGenerator("jdbc:mysql://127.0.0.1:3306/upms?useUnicode=true&useSSL=false&characterEncoding=utf8", "root", "123456")
                .config(config -> {
                    config.setOutputDir("/Users/zhuang/Documents/temp")
                            .setAuthor("zwb")
                            .setBasePackage("com.zhuang.test")
                            .setModuleName("test")
                            .setTableNames("test")
                            .setSwagger(true);
                })
                .generate();
    }

}
