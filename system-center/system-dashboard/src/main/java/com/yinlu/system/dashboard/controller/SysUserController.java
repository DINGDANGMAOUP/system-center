package com.yinlu.system.dashboard.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SysUser;
import com.yinlu.system.dashboard.service.SysUserService;
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

  @GetMapping("/list")
  public Result listByPage(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize){
    Page<SysUser> userPage = new Page<>(page, pageSize);
    Page<SysUser> sysUserPage = sysUserService.page(userPage);
    return Result.success(sysUserPage);
  }

}
