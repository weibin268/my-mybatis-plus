package com.zhuang.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by zwb on 2019-11-28.
 */
@Data
@TableName("sys_user")//
public class User {
    @TableId
    private String id;//
    private String loginId;//登录Id
    private String password;//密码
    private String name;//姓名
    private String sex;//1、F=女；2、M=男；
    private String orgId;//组织Id
    private Integer status;//状态
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;//修改时间
    private String createBy;//创建人Id
    private String modifyBy;//修改人Id
}
