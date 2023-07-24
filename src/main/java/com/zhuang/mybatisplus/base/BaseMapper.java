package com.zhuang.mybatisplus.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface BaseMapper<Entity> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<Entity> {

    <T> IPage<T> getPage(IPage<?> page, Map<String, Object> params);

    int dropByTableName(@Param("tableName")String tableName);

    int countByTableName(@Param("tableName")String tableName);

    int existsByTableName(@Param("tableName")String tableName);
}

