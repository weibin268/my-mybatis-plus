package com.zhuang.mybatisplus.generator;

import org.junit.Test;

public class CodeGeneratorTest {

    @Test
    public void generate() {
        new CodeGenerator("d://temp/codes")
                .setDsDriverName("com.mysql.jdbc.Driver")
                .setDsUrl("jdbc:mysql://weibin268.top:3306/cloud_system?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDsUsername("root")
                .setDsPassword("123456")
                .setAuthorName("zwb")
                .setBasePackage("com.zwb.test")
                .setModuleName("user")
                .setTableNames("sys_user")
                .setTablePrefix("sys_")
                .setRestControllerStyle(true)
                .setSwagger2(true)
                .generate();
    }

    @Test
    public void generate2(){
        new CodeGenerator("d://temp/codes2")
                .setDsDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .setDsUrl("jdbc:sqlserver://192.168.1.130:1433;DatabaseName=yd_ws_gd_zhaoqing_dev")
                .setDsUsername("sa")
                .setDsPassword("123456")
                .setAuthorName("zwb")
                .setBasePackage("com.zwb.test")
                .setModuleName("user")
                .setTableNames("yd_ws_water_user")
                .setTablePrefix("yd_ws_")
                .setRestControllerStyle(true)
                .setSwagger2(true)
                .generate();
    }



    @Test
    public void generate4wms() {
        new CodeGenerator("d://temp/codes")
                .setDsDriverName("com.mysql.jdbc.Driver")
                .setDsUrl("jdbc:mysql://139.9.193.226:3306/stwms_dev?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDsUsername("root")
                .setDsPassword("123456")
                .setAuthorName("zwb")
                .setBasePackage("com.zjmzxfzhl.modules")
                .setModuleName("product")
                .setTableNames("wms_product")
                //.setTablePrefix("sys_")
                .setRestControllerStyle(true)
                .setSwagger2(true)
                .generate();
    }

}
