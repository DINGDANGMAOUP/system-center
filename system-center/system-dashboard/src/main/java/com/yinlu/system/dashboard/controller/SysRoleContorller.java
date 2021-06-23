package com.yinlu.system.dashboard.controller;

import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.service.SysRoleService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class SysRoleContorller {
  @Resource
  SysRoleService sysRoleService;

  @GetMapping("/getAllRoleList")
  public Result getAllRoleList(){
    return Result.success(sysRoleService.list());
  }
}
