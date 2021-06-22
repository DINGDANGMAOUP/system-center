package com.yinlu.system.dashboard.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SysRole;
import com.yinlu.system.dashboard.model.SysUser;
import com.yinlu.system.dashboard.model.SysUserRole;
import com.yinlu.system.dashboard.service.SysRoleService;
import com.yinlu.system.dashboard.service.SysUserRoleService;
import com.yinlu.system.dashboard.service.SysUserService;
import com.yinlu.system.dashboard.utils.SecurityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzhao1
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

  @Resource
  SysUserService sysUserService;
  @Resource
  SysUserRoleService sysUserRoleService;
  @Resource
  SysRoleService sysRoleService;

  @GetMapping("/list")
  public Result listByPage(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize){
    Page<SysUser> userPage = new Page<>(page, pageSize);
    Page<SysUser> sysUserPage = sysUserService.page(userPage);
    return Result.success(sysUserPage);
  }

  @GetMapping("/getUserInfo")
  public Result getUserInfo(){
    String username = SecurityUtils.getUsername();
    SysUser sysUser = sysUserService
        .getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getName, username));
    List<SysUserRole> sysUserRoles = sysUserRoleService
        .list(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, sysUser.getId()));
    List<SysRole> sysRoles=null;
    sysUserRoles.forEach(sysUserRole -> {
      SysRole sysRole = sysRoleService.getById(sysUserRole.getRoleId());
      if (ObjectUtil.isNotNull(sysRole))sysRoles.add(sysRole);
    });
    sysUser.setRoles(sysRoles);
    return Result.success(sysUser);
  }

}
