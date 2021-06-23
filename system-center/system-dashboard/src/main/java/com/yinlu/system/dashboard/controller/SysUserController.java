package com.yinlu.system.dashboard.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.server.HttpServerRequest;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SysRole;
import com.yinlu.system.dashboard.model.SysUser;
import com.yinlu.system.dashboard.model.SysUserRole;
import com.yinlu.system.dashboard.service.SysRoleService;
import com.yinlu.system.dashboard.service.SysUserRoleService;
import com.yinlu.system.dashboard.service.SysUserService;
import com.yinlu.system.dashboard.utils.JwtTokenUtils;
import com.yinlu.system.dashboard.utils.SecurityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzhao1
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

  @Resource
  SysUserService sysUserService;
  @Resource
  SysUserRoleService sysUserRoleService;
  @Resource
  SysRoleService sysRoleService;



  @GetMapping("/getAccountList")
  public Result listByPage(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize,@RequestParam(value = "deptId",required = false) Integer deptId,@RequestParam(value = "account",required = false)String account,@RequestParam(value = "nickname",required = false)String nickname ){
    Page<SysUser> userPage = new Page<>(page, pageSize);
    Page<SysUser> sysUserPage = sysUserService.page(userPage);
    return Result.success(sysUserPage);
  }

}
