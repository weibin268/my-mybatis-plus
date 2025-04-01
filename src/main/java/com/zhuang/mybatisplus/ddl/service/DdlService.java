package com.zhuang.mybatisplus.ddl.service;

import com.zhuang.mybatisplus.base.BaseService;
import com.zhuang.mybatisplus.ddl.entity.DdlEntity;
import com.zhuang.mybatisplus.ddl.mapper.DdlMapper;
import com.zhuang.mybatisplus.ddl.vo.TableInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DdlService extends BaseService<DdlMapper, DdlEntity> {
    public List<TableInfo> getTableInfoList(String prefix) {
        return getMapper().getTableInfoList(prefix);
    }
}
