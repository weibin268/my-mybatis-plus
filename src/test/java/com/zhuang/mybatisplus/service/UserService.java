package com.zhuang.mybatisplus.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.zhuang.mybatisplus.base.BaseService;
import com.zhuang.mybatisplus.entity.User;
import com.zhuang.mybatisplus.mapper.UserMapper;
import com.zhuang.mybatisplus.util.DynamicDataSourceUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2019-11-28.
 */
@Service
public class UserService extends BaseService<UserMapper, User> {

    public List<User> getAllList() {
        List<User> list = DynamicDataSourceUtils.execute("slave1", () -> list(null));
        return list;
    }

    @DS("#ds")
    public List<User> getAllListByDs(String ds) {
        List<User> list = list(null);
        return list;
    }
}
