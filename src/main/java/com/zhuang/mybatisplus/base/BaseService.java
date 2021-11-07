package com.zhuang.mybatisplus.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public abstract class BaseService<Mapper extends BaseMapper<Entity>, Entity> extends ServiceImpl<Mapper, Entity> {

    @Autowired
    protected Mapper mapper;

    public <T> IPage<T> getPage(IPage<?> page, Map<String, Object> params) {
        return mapper.getPage(page, params);
    }

    public Mapper getMapper() {
        return mapper;
    }

}
