package com.wbd.sso.server.service;

import com.wbd.sso.server.model.Credential;
import com.wbd.sso.server.model.LoginUser;

/**
 * 鉴权处理器，接口类，不同登录方式，验证方式不一样，比如，用户名密码登录方式和手机与短信 登录方式
 * 这2中验证方式不一样。但是我们必须提供同一的验证接口
 * @author jwh
 *
 */
public interface IAuthenticationHandler {

	/**
	 * 通过凭证进行登录，
	 * @param credential
	 * @return
	 */
	public LoginUser  authenticate(Credential credential);
}
