package com.zhuang.mybatisplus.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    private AutoGenerator autoGenerator;

    public AutoGenerator getAutoGenerator() {
        return autoGenerator;
    }

    public CodeGenerator setDsDriverName(String driverName) {
        autoGenerator.getDataSource().setDriverName(driverName);
        return this;
    }

    public CodeGenerator setDsUrl(String url) {
        autoGenerator.getDataSource().setUrl(url);
        return this;
    }

    public CodeGenerator setDsUsername(String username) {
        autoGenerator.getDataSource().setUsername(username);
        return this;
    }

    public CodeGenerator setDsPassword(String password) {
        autoGenerator.getDataSource().setPassword(password);
        return this;
    }

    public CodeGenerator setAuthorName(String authorName) {
        autoGenerator.getGlobalConfig().setAuthor(authorName);
        return this;
    }

    public CodeGenerator setModuleName(String moduleName) {
        autoGenerator.getPackageInfo().setModuleName(moduleName);
        return this;
    }

    public CodeGenerator setBasePackage(String basePackage) {
        autoGenerator.getPackageInfo().setParent(basePackage);
        return this;
    }

    public CodeGenerator setTableNames(String tableNames) {
        autoGenerator.getStrategy().setInclude(tableNames.split(","));
        return this;
    }

    public CodeGenerator setTablePrefix(String tablePrefix) {
        autoGenerator.getStrategy().setTablePrefix(tablePrefix);
        return this;
    }

    public CodeGenerator setSwagger2(boolean swagger2) {
        autoGenerator.getGlobalConfig().setSwagger2(swagger2);
        return this;
    }

    public CodeGenerator setRestControllerStyle(boolean restControllerStyle) {
        autoGenerator.getStrategy().setRestControllerStyle(restControllerStyle);
        return this;
    }

    public CodeGenerator() {
        this(System.getProperty("user.dir"));
    }

    public CodeGenerator(String projectPath) {
        // 代码生成器
        autoGenerator = new AutoGenerator();

        //region 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("zwb");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        //globalConfig.setSwagger2(true); 实体属性 Swagger2 注解
        autoGenerator.setGlobalConfig(globalConfig);
        //endregion

        //region 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://weibin268.top:3306/cloud_system?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);
        //endregion

        //region 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("module1");
        packageConfig.setParent("com.zhuang.test");
        autoGenerator.setPackageInfo(packageConfig);
        //endregion

        //region 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 自定义输出配置
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // 自定义配置会被优先输出
        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + joinPath("/src/main/java/", packageConfig.getParent()) + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        fileOutConfigList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + joinPath("/src/main/java/", packageConfig.getParent()) + "/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        autoGenerator.setCfg(injectionConfig);
        //endregion

        //region 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setService(null);
        autoGenerator.setTemplate(templateConfig);
        //endregion

        //region 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        //strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude("table1");
        //strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix("sys_");
        autoGenerator.setStrategy(strategy);
        //endregion

        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
    }

    public void generate() {
        autoGenerator.execute();
    }

    /**
     * 连接路径字符串
     *
     * @param parentDir   路径常量字符串
     * @param packageName 包名
     * @return 连接后的路径
     */
    public static String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
        return parentDir + packageName;
    }

}
