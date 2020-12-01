package com.tanzuhao.core.system.bean;

/**
 * 
 * @功能说明: 用户参数对象
 * @author: tanzuhao
 * @创建时间: 2020年11月18日下午12:13:58
 * @公司名称:
 * @版本: V1.0
 */
public class UserParamBean {

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 密码
	 */
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
