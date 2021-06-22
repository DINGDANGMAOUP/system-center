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
 * 系统配置表
 * @TableName sys_config
 */
@TableName(value ="sys_config")
@Data
public class SysConfig extends BaseEntity implements Serializable {


    /**
     * 数据值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 标签名
     */
    @TableField(value = "label")
    private String label;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 排序（升序）
     */
    @TableField(value = "sort")
    private Integer sort;



    /**
     * 备注信息
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField(value = "del_flag")
    private Byte delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}