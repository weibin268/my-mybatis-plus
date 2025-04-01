package com.zhuang.mybatisplus.ddl.mapper;

import com.zhuang.mybatisplus.base.BaseMapper;
import com.zhuang.mybatisplus.ddl.entity.DdlEntity;
import com.zhuang.mybatisplus.ddl.vo.TableInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DdlMapper extends BaseMapper<DdlEntity> {

    List<TableInfo> getTableInfoList(@Param("prefix") String prefix);

}
