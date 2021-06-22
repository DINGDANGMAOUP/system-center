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
 * 角色菜单
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
public class SysRoleMenu extends BaseEntity implements Serializable {


    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Long menuId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}