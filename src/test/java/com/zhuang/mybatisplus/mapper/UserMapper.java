package com.zhuang.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhuang.mybatisplus.base.BaseMapper;
import com.zhuang.mybatisplus.entity.User;

/**
 * Created by zwb on 2019-11-28.
 */
public interface UserMapper extends BaseMapper<User> {
    User getCurrentUser();

    IPage<User> selectPageVo(IPage<?> page, Integer state);
}
