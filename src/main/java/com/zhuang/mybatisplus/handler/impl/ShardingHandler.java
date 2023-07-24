package com.zhuang.mybatisplus.handler.impl;


import com.zhuang.mybatisplus.handler.DbExecutionContext;
import com.zhuang.mybatisplus.handler.DbExecutionHandler;
import com.zhuang.util.druid.ShardingModifyBaseVisitor;
import com.zhuang.util.druid.ShardingSQLServerUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ShardingHandler implements DbExecutionHandler {

    private static List<ShardingModifyBaseVisitor.TableInfo> tableInfoList = new ArrayList<>();
    private static Pattern excludeSql = Pattern.compile(".*\\bPIVOT\\b.*", Pattern.DOTALL);

    @PostConstruct
    public void init() {
        tableInfoList.add(new ShardingModifyBaseVisitor.TableInfo("sys_user"));
    }

    @Override
    public void handle(DbExecutionContext dbExecutionContext) {
        //druid不支持的sql语法则不做处理
        if (excludeSql.matcher(dbExecutionContext.getSql()).matches()) return;
        String sql = ShardingSQLServerUtils.parseSql(dbExecutionContext.getSql(), tableInfoList);
        if (sql != null) {
            dbExecutionContext.setSql(sql);
        }
    }

}
