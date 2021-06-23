package com.yinlu.system.dashboard.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinlu.system.core.constants.SysConstant;
import com.yinlu.system.dashboard.model.SysMenu;
import com.yinlu.system.dashboard.model.SysMenuMeta;
import com.yinlu.system.dashboard.model.SysMeta;
import com.yinlu.system.dashboard.service.SysMenuMetaService;
import com.yinlu.system.dashboard.service.SysMenuService;
import com.yinlu.system.dashboard.mapper.SysMenuMapper;
import com.yinlu.system.dashboard.service.SysMetaService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
implements SysMenuService{
  @Resource
  SysMenuMapper sysMenuMapper;
  @Resource
  SysMenuMetaService sysMenuMetaService;
  @Resource
  SysMetaService sysMetaService;

  @Override
  public List<SysMenu> findByUser(String userName) {
    if(userName == null || "".equals(userName) || SysConstant.ADMIN.equalsIgnoreCase(userName)) {
      return sysMenuMapper.selectList(Wrappers.<SysMenu>lambdaQuery().select());
    }
    return sysMenuMapper.findByUserName(userName);
  }

  @Override
  public List<SysMenu> findTree(String username, int menuType) {
    List<SysMenu> sysMenus = new ArrayList<>();
    List<SysMenu> menus = findByUser(username);
    menus.forEach(menu->{
      SysMenuMeta menuMeta = sysMenuMetaService
          .getOne(Wrappers.<SysMenuMeta>lambdaQuery().eq(SysMenuMeta::getMenuId, menu.getId()));
      SysMeta meta = sysMetaService.getById(menuMeta.getMetaId());
      if (ObjectUtil.isNotNull(meta))menu.setMeta(meta);
    });
    for (SysMenu menu : menus) {
      if (menu.getParentId() == null || menu.getParentId() == 0) {
        menu.setLevel(0);
        if(!exists(sysMenus, menu)) {
          sysMenus.add(menu);
        }
      }
    }
    sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
    findChildren(sysMenus, menus, menuType);
    return sysMenus;
  }

  private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, int menuType) {
    for (SysMenu sysMenu : sysMenus) {
      List<SysMenu> children = new ArrayList<>();
      for (SysMenu menu : menus) {
        if(menuType == 1 && menu.getType() == 2) {
          // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
          continue ;
        }
        if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())) {
          menu.setParentName(sysMenu.getName());
          menu.setLevel(sysMenu.getLevel() + 1);
          if(!exists(children, menu)) {
            children.add(menu);
          }
        }
      }
      sysMenu.setChildren(children);
      children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
      findChildren(children, menus, menuType);
    }
  }

  private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
    boolean exist = false;
    for(SysMenu menu:sysMenus) {
      if(menu.getId().equals(sysMenu.getId())) {
        exist = true;
      }
    }
    return exist;
  }
}




