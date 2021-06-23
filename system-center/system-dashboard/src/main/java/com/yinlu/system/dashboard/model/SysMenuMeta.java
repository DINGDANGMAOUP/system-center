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
 * 
 * @TableName sys_menu_meta
 */
@TableName(value ="sys_menu_meta")
@Data
public class SysMenuMeta extends BaseEntity implements Serializable {
    /**
     * 菜单id
     */
    @TableField(value = "menu_id")
    private Long menuId;

    /**
     * metaId
     */
    @TableField(value = "meta_id")
    private Long metaId;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}