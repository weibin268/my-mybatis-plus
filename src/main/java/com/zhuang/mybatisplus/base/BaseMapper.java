package com.zhuang.mybatisplus.base;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

public interface BaseMapper<Entity> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<Entity> {

    <T> IPage<T> selectPageVo(IPage<?> page, Map<String, Object> params);

}

