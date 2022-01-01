package com.zhuang.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.function.Consumer;

public class CodeGenerator {

    private FastAutoGenerator fastAutoGenerator;
    private final Config config;

    public CodeGenerator(String url, String username, String password) {
        fastAutoGenerator = FastAutoGenerator.create(url, username, password);
        config = new Config();
    }

    public CodeGenerator config(Consumer<Config> consumer) {
        consumer.accept(config);
        return this;
    }

    public FastAutoGenerator getFastAutoGenerator() {
        return fastAutoGenerator;
    }

    public void generate() {
        fastAutoGenerator.globalConfig(builder -> {
                    if (!StringUtils.isEmpty(config.getAuthor())) {
                        builder.author(config.getAuthor());
                    }
                    if (config.swagger != null && config.getSwagger()) {
                        builder.enableSwagger();
                    }
                    if (config.fileOverride != null && config.fileOverride) {
                        builder.fileOverride();
                    }
                    if (!StringUtils.isEmpty(config.getOutputDir())) {
                        builder.outputDir(config.getOutputDir());
                    }
                })
                .packageConfig(builder -> {
                    if (!StringUtils.isEmpty(config.getBasePackage())) {
                        builder.parent(config.getBasePackage());
                    }
                    if (!StringUtils.isEmpty(config.getModuleName())) {
                        builder.moduleName(config.getModuleName());
                    }
                    if (!StringUtils.isEmpty(config.getMapperXmlDir())) {
                        builder.pathInfo(Collections.singletonMap(OutputFile.mapperXml, config.getMapperXmlDir()));
                    }
                    builder.xml("mapper");
                })
                .strategyConfig(builder -> {
                    if (!StringUtils.isEmpty(config.getTableNames())) {
                        builder.addInclude(config.getTableNames().split(","));
                    }
                    if (!StringUtils.isEmpty(config.getTablePrefix())) {
                        builder.addTablePrefix(config.getTablePrefix().split(","));
                    }
                    if (config.getLombok() != null && config.getLombok()) {
                        builder.entityBuilder().enableLombok();
                    }
                    if (!StringUtils.isEmpty(config.getSuperMapperClass())) {
                        builder.mapperBuilder().superClass(config.getSuperMapperClass());
                    }
                    if (!StringUtils.isEmpty(config.getSuperServiceClass())) {
                        builder.serviceBuilder().superServiceClass(config.getSuperServiceClass());
                    }
                    builder.serviceBuilder().convertServiceFileName((entityName -> entityName + "Service"));
                })
                .injectionConfig(builder -> {

                })
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(builder -> {
                    builder.disable(TemplateType.SERVICEIMPL);
                });
        fastAutoGenerator.execute();
    }

    @Data
    public static class Config {
        private String author = "zwb";
        private Boolean swagger;
        private Boolean fileOverride = true;
        private String outputDir;
        private String basePackage;
        private String moduleName;
        private String mapperXmlDir;
        private String tableNames;
        private String tablePrefix;
        private Boolean lombok = true;
        private String superMapperClass = "com.zhuang.mybatisplus.base.BaseMapper";
        private String superServiceClass = "com.zhuang.mybatisplus.base.ServiceMapper";
    }
}
