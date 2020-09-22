package com.zhuang.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.zhuang.mybatisplus.interceptor.EnvTagInterceptor;
import com.zhuang.mybatisplus.interceptor.PermissionTagInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MybatisPlusInterceptor.class)
public class MybatisPlusConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(permissionTagInterceptor());
        interceptor.addInnerInterceptor(envTagInterceptor());
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

    @Bean
    public EnvTagInterceptor envTagInterceptor() {
        return new EnvTagInterceptor() {
            @Override
            public String getEnvValue(String envName) {
                System.out.println("envName = " + envName);
                return envName.equals("user.userId") ? "zwb" : "";
            }
        };
    }

    @Bean
    public PermissionTagInterceptor permissionTagInterceptor() {
        return new PermissionTagInterceptor() {
            @Override
            public String getPermissionExpression(String permissionCode) {
                System.out.println("permissionCode = " + permissionCode);
                if (permissionCode.equals("user:query:all"))
                    return " 1=1 ";
                else
                    return null;
            }
        };
    }
}
