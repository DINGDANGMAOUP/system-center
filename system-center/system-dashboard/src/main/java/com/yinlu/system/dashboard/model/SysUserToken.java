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
 * 用户Token
 * @TableName sys_user_token
 */
@TableName(value ="sys_user_token")
@Data
public class SysUserToken extends BaseEntity implements Serializable {


    /**
     * 
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * token
     */
    @TableField(value = "token")
    private String token;

    /**
     * 过期时间
     */
    @TableField(value = "expire_time")
    private LocalDateTime expireTime;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}