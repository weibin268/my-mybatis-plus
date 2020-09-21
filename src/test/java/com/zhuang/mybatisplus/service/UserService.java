package com.zhuang.mybatisplus.service;

import com.zhuang.mybatisplus.base.BaseService;
import com.zhuang.mybatisplus.entity.User;
import com.zhuang.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * Created by zwb on 2019-11-28.
 */
@Service
public class UserService extends BaseService<UserMapper, User> {

}
