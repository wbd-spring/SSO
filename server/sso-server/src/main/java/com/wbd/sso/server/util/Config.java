package com.wbd.sso.server.util;

import com.wbd.sso.server.service.IAuthenticationHandler;

/**
 * 应用配置信息
 * 
 * @author jwh
 *
 */
public class Config {

	private String loginViewName = "/login"; // 登录页面视图名称
	
	private IAuthenticationHandler iAuthenticationHandler;
	
	/**
	 * 获取当前鉴权处理器
	 * 
	 * @return
	 */
	public IAuthenticationHandler getAuthenticationHandler() {
		return iAuthenticationHandler;
	}

	public void setAuthenticationHandler(
			IAuthenticationHandler authenticationHandler) {
		this.iAuthenticationHandler = authenticationHandler;
	}

	/**
	 * 获取登录页面视图名称
	 * 
	 * @return
	 */
	public String getLoginViewName() {
		return loginViewName;
	}

	public void setLoginViewName(String loginViewName) {
		this.loginViewName = loginViewName;
	}
}
