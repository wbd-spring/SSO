package demo.sso.logout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.sso.TokenUserData;
import demo.sso.common.CookieUtil;

/**
 * 用户注销
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String token = CookieUtil.getCookie(request, "token");
		if (token != null) {
			TokenUserData.removeToken(token);
		}

		//用户点击退出，先删除服务器端存储的token信息， 然后利用CookieUtil清除客户端的token信息， 下次在登录，不能携带token，
		//下次登录， 让它填写用户名和密码，清除浏览器的cookie实际上是把cookie的有效时间设置为负数，即为失效(删除)。cookie.setMaxAge(-1000);
		CookieUtil.removeCookie(response, "token", "/", null);
		
		response.getWriter().write("logout success");
	}

}
