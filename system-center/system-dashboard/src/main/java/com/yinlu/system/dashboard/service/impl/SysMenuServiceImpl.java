package com.yinlu.system.dashboard.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinlu.system.core.constants.SysConstant;
import com.yinlu.system.dashboard.model.SysMenu;
import com.yinlu.system.dashboard.service.SysMenuService;
import com.yinlu.system.dashboard.mapper.SysMenuMapper;
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

  @Override
  public List<SysMenu> findByUser(String userName) {
    if(userName == null || "".equals(userName) || SysConstant.ADMIN.equalsIgnoreCase(userName)) {
      return sysMenuMapper.selectList(Wrappers.<SysMenu>lambdaQuery().select());
    }
    return sysMenuMapper.findByUserName(userName);
  }
}




