package com.tanzuhao.core.system.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanzuhao.core.constant.BaseEnums;
import com.tanzuhao.core.constant.Constants;
import com.tanzuhao.core.model.User;
import com.tanzuhao.core.system.bean.UserParamBean;
import com.tanzuhao.core.system.service.UserService;
import com.tanzuhao.core.util.Result;
import com.tanzuhao.core.util.Results;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户Controller 访问地址:
 * 
 * http://localhost:8086/sys/user/listUser
 * http://localhost:8086/sys/user/findById/13
 * http://localhost:8086/sys/user/save?username=tanzxuhao
 * http://localhost:8086/sys/user/update?userId=5&username=小米
 * http://localhost:8086/sys/user/delete/1
 * 
 * @author tanzuhao
 *
 */
@RequestMapping("/sys/user")
@RestController
@Api(tags = { "APP端-用户管理" }, description = "APP端-用户管理")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listUser", method = { RequestMethod.GET }, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value = "查询用户列表", tags = { "用户管理" })
	public Result listUser() {
		// List<User> list = userService.selectAll();//调用通用查询方法
		List<User> list = userService.listUser();
		return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
	}

	/**
	 * @PathVariable是用来获得请求url中的动态参数
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/findById/{userId}", method = { RequestMethod.GET }, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value = "查询用户列表", tags = { "用户管理" })
	public Result findById(@ApiParam(required = true, value = "用户ID") @PathVariable Long userId) {
		User user = userService.get(userId);
		return Results.successWithData(user);
	}

	/**
	 * 新增用户
	 * 
	 * @param username
	 * @return
	 */
	@PostMapping(value = "/save", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "新增用户对象", notes = "新增用户对象")
	public Result save(@RequestBody UserParamBean userBean) {
		User user1 = new User();
		user1.setUsername(userBean.getUsername());
		user1.setNickname(userBean.getNickname());
		user1.setBirthday(new Date());
		user1.setSex(Constants.Sex.MALE);
		user1.setEnabled(Constants.Flag.YES);
		user1.setPassword(userBean.getPassword());
		// user1 = userService.insertSelective(user1);//调用通用新增方法
		userService.insertUser(user1);
		return Results.successWithData(user1);
	}

	/**
	 * 更新用户
	 * 
	 * @param userId
	 * @param username
	 * @return
	 */
	@PostMapping(value = "/update", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "修改用户对象", notes = "修改用户对象")
	public Result update(@RequestBody UserParamBean userBean) {
		User user = userService.get(userBean.getUserId());
		user.setUsername(userBean.getUsername());
		user.setNickname(userBean.getNickname());
		user.setPassword(userBean.getPassword());
		userService.update(user);// 调用通用更新方法
		// userService.updateUser(user);
		return Results.successWithData(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "删除用户", tags = { "用户管理" })
	@RequestMapping(value = "/delete/{userId}", method = { RequestMethod.GET }, produces = {
			"application/json;charset=UTF-8" })
	public Result delete(@ApiParam(required = true, value = "用户ID") @PathVariable Long userId) {
		// userService.delete(userId);//调用通用删除方法
		userService.deleteById(userId);// 调用业务删除方法
		return Results.success();
	}

}