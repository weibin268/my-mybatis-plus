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
 * @permission{security:user:query ? and 1=1}
 **/
public abstract class PermissionTagInterceptor implements InnerInterceptor {

    private CustomTagHandler permissionTagHandler = new CustomTagHandler("permission") {
        @Override
        public String handleInternal(String tagContent) {
            String result;
            String[] tag = tagContent.split("\\?");
            String permissionCode = tag[0];
            String defaultValue = tag[1];
            String permissionExpression = getPermissionExpression(permissionCode.trim());
            if (permissionExpression != null && !permissionExpression.isEmpty()) {
                result = permissionExpression;
            } else {
                result = defaultValue;
            }
            return result;
        }
    };

    public abstract String getPermissionExpression(String permissionCode);

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        PluginUtils.MPBoundSql mpBoundSql = PluginUtils.mpBoundSql(boundSql);
        mpBoundSql.sql(permissionTagHandler.handle(boundSql.getSql()));
    }

}
