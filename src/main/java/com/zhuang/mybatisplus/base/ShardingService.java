package com.zhuang.mybatisplus.base;

import com.zhuang.util.druid.ShardingNameHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ShardingService {

    void createByTableName(String tableName);

    List<String> getShardingNameList();

    default void initTable() {
        List<String> shardingNameList = getShardingNameList();
        if (CollectionUtils.isEmpty(shardingNameList)) return;
        shardingNameList.forEach(shardingName -> {
            dropByShardingName(shardingName);
            createByShardingName(shardingName);
        });
    }

    default void createByShardingName(String shardingName) {
        if (StringUtils.isEmpty(shardingName)) return;
        String tableName = getTableName(shardingName);
        createByTableName(tableName);
    }

    int dropByTableName(String tableName);

    String getTableName();

    default String getTableName(String shardingName) {
        if (shardingName == null) return getTableName();
        return getTableName() + getDelimiter() + shardingName;
    }

    default int dropByShardingName(String shardingName) {
        if (StringUtils.isEmpty(shardingName)) return 0;
        String tableName = getTableName(shardingName);
        return dropByTableName(tableName);
    }

    default String getDelimiter() {
        return "_";
    }

    default void setShardingName(String shardingName) {
        ShardingNameHolder.setShardingName(getTableName(), shardingName);
    }

    default String getShardingName() {
        return ShardingNameHolder.getShardingName(getTableName());
    }

    default void removeShardingName() {
        ShardingNameHolder.removeShardingName(getTableName());
    }

}
