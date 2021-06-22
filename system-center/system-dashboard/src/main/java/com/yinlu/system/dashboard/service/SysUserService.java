package com.yinlu.system.dashboard.service;

import com.yinlu.system.dashboard.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Set;

/**
 *
 */
public interface SysUserService extends IService<SysUser> {

  Set<String> findPermissions(String name);
}
