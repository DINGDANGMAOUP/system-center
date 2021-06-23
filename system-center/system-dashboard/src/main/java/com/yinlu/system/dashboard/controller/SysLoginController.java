package com.yinlu.system.dashboard.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SysMenu;
import com.yinlu.system.dashboard.model.SysRole;
import com.yinlu.system.dashboard.model.SysUser;
import com.yinlu.system.dashboard.model.SysUserRole;
import com.yinlu.system.dashboard.pojo.vo.LoginBean;
import com.yinlu.system.dashboard.security.JwtAuthenticatioToken;
import com.yinlu.system.dashboard.service.SysMenuService;
import com.yinlu.system.dashboard.service.SysRoleService;
import com.yinlu.system.dashboard.service.SysUserRoleService;
import com.yinlu.system.dashboard.service.SysUserService;
import com.yinlu.system.dashboard.utils.JwtTokenUtils;
import com.yinlu.system.dashboard.utils.PasswordUtils;
import com.yinlu.system.dashboard.utils.SecurityUtils;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录控制器
 */
@RestController
public class SysLoginController {

	@Resource
	private SysUserService sysUserService;
	@Resource
	private AuthenticationManager authenticationManager;
	@Resource
	SysUserRoleService sysUserRoleService;
	@Resource
	SysRoleService sysRoleService;
	@Resource
	SysMenuService sysMenuService;


	/**
	 * 登录接口
	 */
	@PostMapping(value = "/login")
	public Result login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		// 用户信息
		SysUser user = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getName,username));
		// 账号不存在、密码错误
		if (user == null) {
			return Result.fail("账号不存在");
		}
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return Result.fail("密码不正确");
		}
		// 账号锁定
		if (user.getStatus() == 0) {
			return Result.fail("账号已被锁定,请联系管理员");
		}
		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils
				.login(request, username, password, authenticationManager);
		return Result.success(token);
	}


	/**
	 * 获取用户信息
	 * @param httpServletRequest
	 * @return
	 */
	@GetMapping("/getUserInfo")
	public Result getUserInfo(HttpServletRequest httpServletRequest){
		String username = JwtTokenUtils.getUsernameFromRequest(httpServletRequest);
		SysUser sysUser = sysUserService
				.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getName, username));
		List<SysUserRole> sysUserRoles = sysUserRoleService
				.list(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, sysUser.getId()));
		List<SysRole> sysRoles=new ArrayList<>();
		sysUserRoles.forEach(sysUserRole -> {
			SysRole sysRole = sysRoleService.getById(sysUserRole.getRoleId());
			if (ObjectUtil.isNotNull(sysRole))sysRoles.add(sysRole);
		});
		sysUser.setRoles(sysRoles);
		return Result.success(sysUser);
	}

	/**
	 * 获取用户权限
	 * @param httpServletRequest
	 * @return
	 */
	@GetMapping("/getPermCode")
	public Result getPermCode(HttpServletRequest httpServletRequest){
		String username = JwtTokenUtils.getUsernameFromRequest(httpServletRequest);
		Set<String> permissions = sysUserService.findPermissions(username);
		return Result.success(permissions);
	}

	@GetMapping("/getMenuList")
	public Result getMenuList(HttpServletRequest httpServletRequest){
		String username = JwtTokenUtils.getUsernameFromRequest(httpServletRequest);
		List<SysMenu> sysMenus=sysMenuService.findTree(username, 1);
		return Result.success(sysMenus);
	}

}
