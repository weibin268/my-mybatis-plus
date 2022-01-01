package com.zhuang.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;
import lombok.experimental.Accessors;
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
                    if (config.getSwagger() != null && config.getSwagger()) {
                        builder.enableSwagger();
                    }
                    if (config.getFileOverride() != null && config.getFileOverride()) {
                        builder.fileOverride();
                    }
                    if (!StringUtils.isEmpty(config.getOutputDir())) {
                        builder.outputDir(config.getOutputDir());
                    }
                    if (config.getDateType() != null) {
                        builder.dateType(config.getDateType());
                    }
                    if (config.getOpen() != null && !config.getOpen()) {
                        builder.disableOpenDir();
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
    @Accessors(chain = true)
    public static class Config {
        private String outputDir;
        private String tableNames;
        private String tablePrefix;
        private String author = "zwb";
        private Boolean swagger = false;
        private Boolean lombok = true;
        private Boolean fileOverride = true;
        private String basePackage;
        private String moduleName;
        private String superMapperClass = "com.zhuang.mybatisplus.base.BaseMapper";
        private String superServiceClass = "com.zhuang.mybatisplus.base.ServiceMapper";
        private DateType dateType = DateType.ONLY_DATE;
        private Boolean open;
        private String mapperXmlDir;
    }
}
