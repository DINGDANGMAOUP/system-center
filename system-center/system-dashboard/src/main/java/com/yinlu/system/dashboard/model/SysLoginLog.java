package com.yinlu.system.dashboard.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yinlu.system.core.base.BaseEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 系统登录日志
 * @TableName sys_login_log
 */
@TableName(value ="sys_login_log")
@Data
public class SysLoginLog extends BaseEntity implements Serializable {


    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）
     */
    @TableField(value = "status")
    private String status;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    private String ip;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}