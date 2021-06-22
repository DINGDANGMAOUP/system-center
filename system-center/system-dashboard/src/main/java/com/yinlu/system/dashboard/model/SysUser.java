package com.yinlu.system.dashboard.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yinlu.system.core.base.BaseEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 * 用户管理
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser extends BaseEntity implements Serializable {


    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 加密盐
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 机构ID
     */
    @TableField(value = "dept_id")
    private Long deptId;



    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField(value = "del_flag")
    private Byte delFlag;

    @TableField(exist = false)
    private List<SysRole> roles;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}