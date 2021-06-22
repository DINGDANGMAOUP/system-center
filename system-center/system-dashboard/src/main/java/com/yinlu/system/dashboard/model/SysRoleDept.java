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
 * 角色机构
 * @TableName sys_role_dept
 */
@TableName(value ="sys_role_dept")
@Data
public class SysRoleDept extends BaseEntity implements Serializable {


    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 机构ID
     */
    @TableField(value = "dept_id")
    private Long deptId;




    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}