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
 * 系统操作日志
 * @TableName sys_log
 */
@TableName(value ="sys_log")
@Data
public class SysLog extends BaseEntity implements Serializable {


    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 用户操作
     */
    @TableField(value = "operation")
    private String operation;

    /**
     * 请求方法
     */
    @TableField(value = "method")
    private String method;

    /**
     * 请求参数
     */
    @TableField(value = "params")
    private String params;

    /**
     * 执行时长(毫秒)
     */
    @TableField(value = "time")
    private Long time;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    private String ip;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}