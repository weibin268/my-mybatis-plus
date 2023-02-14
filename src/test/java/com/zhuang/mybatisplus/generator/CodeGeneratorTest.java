package com.zhuang.mybatisplus.generator;

import org.junit.Test;

public class CodeGeneratorTest {

    @Test
    public void gx() {
        new CodeGenerator("jdbc:mysql://192.168.1.153:3306/rese-c?useUnicode=true&useSSL=false&characterEncoding=utf8", "root", "Gd_demo@123456")
                .config(config -> {
                    config.setOutputDir("D:\\temp\\code")
                            .setAuthor("zwb")
                            .setBasePackage("com.hhwy.rese.ext")
                            .setModuleName("reservoir")
                            .setTableNames("hyd_bi_lrinf_b_level_capacity")
                            .setSwagger(true);
                })
                .generate();
    }

    @Test
    public void iot() {
        new CodeGenerator("jdbc:mysql://192.168.3.181:3306/sliotlinks?useUnicode=true&useSSL=false&characterEncoding=utf8", "root", "sliotlinks-2022")
                .config(config -> {
                    config.setOutputDir("D:\\temp\\code")
                            .setAuthor("zwb")
                            .setBasePackage("com.mqttsnet.thinglinks.link")
                            .setModuleName("device")
                            .setTableNames("device_command_log")
                            .setSwagger(true);
                })
                .generate();
    }

    @Test
    public void mssql() {
        new CodeGenerator("jdbc:sqlserver://192.168.0.200:1433;database=upms", "sa", "a@123456")
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
