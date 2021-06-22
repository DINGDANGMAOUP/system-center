package com.yinlu.system.dashboard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinlu.system.dashboard.model.SysMenu;
import com.yinlu.system.dashboard.model.SysUser;
import com.yinlu.system.dashboard.service.SysMenuService;
import com.yinlu.system.dashboard.service.SysUserService;
import com.yinlu.system.dashboard.mapper.SysUserMapper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
implements SysUserService{

  @Resource
  SysUserMapper sysUserMapper;

  @Resource
  SysMenuService sysMenuService;

  @Override
  public Set<String> findPermissions(String userName) {
    Set<String> perms = new HashSet<>();
    List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
    for(SysMenu sysMenu:sysMenus) {
      if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
        perms.add(sysMenu.getPerms());
      }
    }
    return perms;
  }
}




