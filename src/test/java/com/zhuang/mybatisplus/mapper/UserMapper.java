package com.zhuang.mybatisplus.mapper;


import com.zhuang.mybatisplus.base.BaseMapper;
import com.zhuang.mybatisplus.entity.User;

/**
 * Created by zwb on 2019-11-28.
 */
public interface UserMapper extends BaseMapper<User> {
    User getCurrentUser();
}
