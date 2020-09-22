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
import java.util.function.Function;

/**
 * @author zhuang
 * @create 6/2/18 10:10 PM
 * 处理格式如下的自定义标签：
 * @env{user.userId}
 **/
public class EnvTagInterceptor implements InnerInterceptor {

    private CustomTagHandler envTagHandler = new CustomTagHandler("env") {
        @Override
        public String handleInternal(String tagContent) {
            return getEnvValueByEnvName.apply(tagContent.trim());
        }
    };

    private Function<String, String> getEnvValueByEnvName;

    public EnvTagInterceptor(Function<String, String> getEnvValueByEnvName) {
        this.getEnvValueByEnvName = getEnvValueByEnvName;
    }

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        PluginUtils.MPBoundSql mpBoundSql = PluginUtils.mpBoundSql(boundSql);
        mpBoundSql.sql(envTagHandler.handle(boundSql.getSql()));
    }

}
