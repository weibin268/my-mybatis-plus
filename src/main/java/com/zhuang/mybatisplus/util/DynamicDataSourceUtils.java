package com.zhuang.mybatisplus.util;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.function.Supplier;

@Component
public class DynamicDataSourceUtils {

    private static DynamicDataSourceUtils _this;
    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;
    @Autowired
    private DatabaseIdProvider databaseIdProvider;

    @PostConstruct
    private void init() {
        _this = this;
    }

    public static <T> T execute(String ds, Supplier<T> func) {
        DynamicDataSourceContextHolder.push(ds);
        try {
            return func.get();
        } finally {
            DynamicDataSourceContextHolder.poll();
        }
    }

    public static String getDataBaseId() {
        String currentDataSource = DynamicDataSourceContextHolder.peek();
        DataSource dataSource = _this.dynamicRoutingDataSource.getDataSource(currentDataSource);
        try {
            return _this.databaseIdProvider.getDatabaseId(dataSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
