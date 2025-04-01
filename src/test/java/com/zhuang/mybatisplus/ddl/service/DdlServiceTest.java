package com.zhuang.mybatisplus.ddl.service;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhuang.mybatisplus.MyMybatisPlusApplicationTest;
import com.zhuang.mybatisplus.ddl.vo.TableInfo;
import com.zhuang.mybatisplus.util.DynamicDataSourceUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class DdlServiceTest extends MyMybatisPlusApplicationTest {

    @Autowired
    private DdlService ddlService;


    @Test
    public void test() {
        List<TableInfo> tableInfoList = ddlService.getTableInfoList("yd");
        for (TableInfo tableInfo : tableInfoList) {
            System.out.println(tableInfo.getName());
        }
    }
}