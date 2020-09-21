package com.zhuang.mybatisplus.interceptor;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.zhuang.mybatisplus.handler.CustomTagHandler;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;

/**
 * @author zhuang
 * @create 6/2/18 10:10 PM
 * 处理格式如下的自定义标签：
 * @env{user.userId}
 **/
public abstract class EnvTagInterceptor implements InnerInterceptor {

    private CustomTagHandler envTagHandler = new CustomTagHandler("env") {
        @Override
        public String handleInternal(String tagContent) {
            return getEnvValue(tagContent.trim());
        }
    };

    public abstract String getEnvValue(String envName);

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        PluginUtils.MPBoundSql mpBoundSql = PluginUtils.mpBoundSql(boundSql);
        mpBoundSql.sql(envTagHandler.handle(boundSql.getSql()));
    }
}
