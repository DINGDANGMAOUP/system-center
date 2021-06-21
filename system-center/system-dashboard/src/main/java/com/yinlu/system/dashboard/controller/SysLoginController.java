package com.yinlu.system.dashboard.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SysUser;
import com.yinlu.system.dashboard.pojo.vo.LoginBean;
import com.yinlu.system.dashboard.security.JwtAuthenticatioToken;
import com.yinlu.system.dashboard.service.SysUserService;
import com.yinlu.system.dashboard.utils.PasswordUtils;
import com.yinlu.system.dashboard.utils.SecurityUtils;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录控制器
 */
@RestController
public class SysLoginController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private AuthenticationManager authenticationManager;


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

}
