package com.zhuang.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuang.mybatisplus.MyMybatisPlusApplicationTest;
import com.zhuang.mybatisplus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends MyMybatisPlusApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = userService.getMapper().getCurrentUser();
        System.out.println(user);
        System.out.println(userService.getTableName());
    }

    @Test
    public void getAllList() {
        List<User> allList = userService.getAllList();
        System.out.println(allList);
    }

    @Test
    public void getAllListByDs() {
        List<User> allList = userService.getAllListByDs("dameng");
        System.out.println(allList);
    }

    @Test
    public void selectPageVo() {
        IPage<User> userPage = new Page<>();
        userPage.setCurrent(1);
        userPage.setPages(10);
        userPage = userService.selectPageVo(userPage, 1);
        System.out.println(userService);
    }
}
