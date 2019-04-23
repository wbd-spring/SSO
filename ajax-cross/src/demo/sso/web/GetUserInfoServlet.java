package demo.sso.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 示例性的，以json形式返回用户信息的servlet
 */
@WebServlet("/user_info")
public class GetUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 非简单请求，如 POST类型请求，或请求中有其它自定义Header，会执行一次preflight操作，浏览器会发起一次OPTIONS类型请求<br>
	 * 要对OPTIONS请求给予正确应答
	 */
//	@Override
//	protected void doOptions(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("OPTIONS");
//		 response.addHeader("Access-Control-Allow-Origin", "*");
//
//		response.addHeader("Access-Control-Allow-Methods",
//       	"GET, POST, OPTIONS, DELETE");
//		 response.addHeader("Access-Control-Allow-Headers", "reqid, xxxx");
//	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 简单请求，直接设置Access-Control-Allow-Origin就可以了
		response.addHeader("Access-Control-Allow-Origin", "*"); //表示任意域名来源都被允许

		// 要正确设置响应类型，避免IE出现下载
		response.setContentType("application/json");
		//response.setContentType("application/javascript");
		
		response.getWriter().write("{\"id\":1, \"name\":\"zhangsan\"}");
		String userInfo = "{\"id\":1, \"name\":\"zhangsan\"}";
		
		// String ret = "showResult(" + userInfo + ");";
		 
		 
//			String callback = request.getParameter("callback");
//			String ret = callback + "(" + userInfo + ")";
//		 
//		 response.getWriter().write(ret);
//		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
}
