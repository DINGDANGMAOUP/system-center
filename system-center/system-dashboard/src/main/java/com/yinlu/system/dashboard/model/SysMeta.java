package com.yinlu.system.dashboard.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yinlu.system.core.base.BaseEntity;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_meta
 */
@TableName(value ="sys_meta")
@Data
public class SysMeta extends BaseEntity implements Serializable {
    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 是否忽略权限
     */
    @TableField(value = "ignore_auth")
    private Boolean ignoreAuth;

    /**
     * 可以访问的角色
     */
    @TableField(value = "roles")
    private String roles;

    /**
     * 是否忽略KeepAlive缓存
     */
    @TableField(value = "ignore_keep_alive")
    private Boolean ignoreKeepAlive;

    /**
     * 是否固定标签
     */
    @TableField(value = "affix")
    private Boolean affix;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 内嵌iframe的地址
     */
    @TableField(value = "frame_src")
    private String frameSrc;

    /**
     * 指定该路由切换的动画名
     */
    @TableField(value = "transition_name")
    private String transitionName;

    /**
     * 隐藏该路由在面包屑上面的显示
     */
    @TableField(value = "hide_breadcrumb")
    private Boolean hideBreadcrumb;

    /**
     * 如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true
     */
    @TableField(value = "carry_param")
    private String carryParam;

    /**
     * 隐藏所有子菜单
     */
    @TableField(value = "hide_children_in_menu")
    private Boolean hideChildrenInMenu;

    /**
     * 当前激活的菜单。用于配置详情页时左侧激活的菜单路径
     */
    @TableField(value = "current_active_menu")
    private String currentActiveMenu;

    /**
     * 当前路由不再标签页显示
     */
    @TableField(value = "hide_tab")
    private Boolean hideTab;

    /**
     * 当前路由不再菜单显示
     */
    @TableField(value = "hide_menu")
    private Boolean hideMenu;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}