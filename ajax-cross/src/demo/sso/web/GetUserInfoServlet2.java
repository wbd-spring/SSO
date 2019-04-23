package demo.sso.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支持jsonp
 */
@WebServlet("/user_info_2")
public class GetUserInfoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 要正确设置响应类型，避免IE出现下载
		response.setContentType("application/javascript");

		String userInfo = "{\"id\":1, \"name\":\"zhangsan\"}";

		// 返回拼接的javascript语句字符串，语句本身执行一个调用函数的操作
//		 String ret = "showResult(" + userInfo + ");";

		// 通过参数传递回调函数名，一定程度降低了前后端代码的耦合度
		String callback = request.getParameter("callback");
		String ret = callback + "(" + userInfo + ")";

		response.getWriter().write(ret);
	}

}
