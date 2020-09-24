package com.zhuang.mybatisplus.generator;

import org.junit.Test;

public class CodeGeneratorTest {

    @Test
    public void generate() {
        new CodeGenerator()
                .setDsDriverName("com.mysql.jdbc.Driver\"")
                .setDsUrl("jdbc:mysql://weibin268.top:3306/cloud_system?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDsUsername("root")
                .setDsPassword("123456")
                .setAuthorName("zwb")
                .setModuleName("user")
                .setBasePackage("com.zwb.test")
                .setTableNames("sys_user")
                .generate();
    }

}
