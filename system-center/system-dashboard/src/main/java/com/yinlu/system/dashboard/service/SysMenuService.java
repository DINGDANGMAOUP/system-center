package com.yinlu.system.dashboard.service;

import com.yinlu.system.dashboard.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface SysMenuService extends IService<SysMenu> {

  List<SysMenu> findByUser( String userName);

  /**
   * 查询菜单树,用户名为空则查询全部
   * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
   * @param username 用户名
   * @return
   */
  List<SysMenu> findTree(String username, int menuType);
}
