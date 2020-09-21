package com.zhuang.mybatisplus.service;

import com.zhuang.mybatisplus.MyMybatisPlusApplicationTest;
import com.zhuang.mybatisplus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends MyMybatisPlusApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = userService.getById("1");
        System.out.println(user);
    }

}
