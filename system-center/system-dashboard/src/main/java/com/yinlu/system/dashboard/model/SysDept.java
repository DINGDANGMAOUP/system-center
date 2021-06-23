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
 * 机构管理
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
@Data
public class SysDept extends BaseEntity implements Serializable {


    /**
     * 机构名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 上级机构ID，一级机构为0
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;


    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField(value = "del_flag")
    private Byte delFlag;

    @TableField(exist = false)
    private List<SysDept> children;
    @TableField(exist = false)
    private String parentName;
    @TableField(exist = false)
    private Integer level;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



}