package com.wbd.sso.server.service;

import com.wbd.sso.server.model.Credential;
import com.wbd.sso.server.model.DemoLoginUser;
import com.wbd.sso.server.model.LoginUser;

/**
 * 一般验证方式有， 
 * 1.用户名密码 
 * 2.手机号码+短信 
 * 3.二维码 我们这里采用第一种方式，
 * 
 * @author jwh
 *
 */
public class DemoAuthticationHandler implements IAuthenticationHandler {

	@Override
	public LoginUser authenticate(Credential credential) {
		String name = credential.getParameter("name");
		String password = credential.getParameter("password");
		DemoLoginUser lu = new DemoLoginUser();
		if ("admin".equals(name) && "123456".equals(password)) {

			lu.setLoginName(name);

			return lu;
		}else {
			credential.setError("validate error");
			return lu;
		}

	}

}
