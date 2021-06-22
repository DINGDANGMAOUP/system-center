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
 * 角色管理
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole extends BaseEntity implements Serializable {


    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;



    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField(value = "del_flag")
    private Byte delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;




}