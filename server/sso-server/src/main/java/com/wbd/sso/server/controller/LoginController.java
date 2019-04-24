package com.wbd.sso.server.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wbd.sso.common.CookieUtil;
import com.wbd.sso.common.StringUtil;
import com.wbd.sso.server.model.Credential;
import com.wbd.sso.server.model.LoginUser;
import com.wbd.sso.server.util.Config;
import com.wbd.sso.server.util.TokenManager;

@Controller
public class LoginController {

	@Autowired
	private Config config;

	/**
	 * 登录入口页面
	 * 
	 * @param request
	 * @param backUrl
	 * @param response
	 * @param map
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, String backUrl, HttpServletResponse response, ModelMap map)
			throws IOException {
		// 1.先通过CookieUtil获取token
		String vt = CookieUtil.getCookie("VT", request);

		if (vt == null) {// token不存
			// 查看自动登录标识LT是否存
			String lt = CookieUtil.getCookie("LT", request);
			if (lt == null) { // 如果token和自动标识都不存在，让用户跳转到登录页面进行登录

				return config.getLoginViewName();
			} else { // 如果token不存在， 但是自动标识存在，这自动登录

				// TODO 自动登录流程
				return null;
			}

		} else { // 如果token存在，验证token的有效性

			LoginUser lu = TokenManager.validate(vt);

			if (lu != null) { // 验证成功
				return validateSuccess(backUrl, vt, response, map); // 验证成功后操作
			} else { // 验证失败，转到登录

				return config.getLoginViewName();
			}

		}

	}

	/**
	 * 验证token成功之后的操作
	 * 
	 * @param backUrl
	 * @param vt
	 * @param response
	 * @param map
	 * @return
	 * @throws IOException
	 */
	private String validateSuccess(String backUrl, String vt, HttpServletResponse response, ModelMap map)
			throws IOException {

		// 如果是通过业务系统过来进行登录，成功之后直接重定向到业务系统页面,顺便
		// 通过浏览器地址参数把token传递到业务系统的浏览器中

		if (backUrl != null) {

			response.sendRedirect(StringUtil.appendUrlParameter(backUrl, "VT", vt));

			return null;

		} else { // 如果用户是直接 登录sso-server的登录页面，成功之后应该直接获取业务系统列表

			map.put("sysList", null); // TODO 获取业务系统列表
			map.put("vt", vt);
			return config.getLoginViewName(); // TODO 未完成

		}

	}

	/**
	 * 登录验证 POST请求
	 * 
	 * @param backUrl
	 * @param rememberMe
	 * @param request
	 * @param session
	 * @param response
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(String backUrl, Boolean rememberMe, HttpServletRequest request, HttpSession session,
			HttpServletResponse response, ModelMap map) throws Exception {

		// 获取表单提交的所以参数
		Map<String, String[]> params = request.getParameterMap();

		// 创建登录凭据对象
		Credential credential = new Credential() {

			@Override
			public String getParameter(String name) {
				String[] str = params.get(name);
				return str != null && str.length > 0 ? str[0] : null;
			}

			@Override
			public String[] getParameterValue(String name) {
				return params.get(name);
			}

			@Override
			public Object getSettedSessionValue() {
				return null;
			}
		};

		// 进行验证
		LoginUser lu = config.getAuthenticationHandler().authenticate(credential);

		if (lu == null) { //如果验证失败， 跳转到登录页面

			map.put("errorMsg", credential.getError());
			return config.getLoginViewName();
		}else { //如果成功，服务器生成token，自动登录标识，存入map，写出到cookie中
			
			String vt = authSuccess(response, rememberMe);
			return validateSuccess(backUrl, vt, response, map);
		}

		
	}

	
	    // 授权成功后的操作
		private String  authSuccess(HttpServletResponse response, Boolean rememberMe) {
			// 生成VT
			// 生成LT？
			// 存入Map
			// Cookie
			return "null";
		}
}
