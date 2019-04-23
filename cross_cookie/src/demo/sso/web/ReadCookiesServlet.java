package demo.sso.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 调用此servlet时，读取当前全部cookie并将结果拼接成js赋值语句返回，返回类型为application/javascript
 */
@WebServlet("/read_cookies")
public class ReadCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		StringBuilder builder = new StringBuilder();
		
		// 一定要正确设置响应类型，否则可能导致IE不解析js而直接进行下载操作
		response.setContentType("application/javascript");
		
		
		if (cookies != null) {			
			PrintWriter writer = response.getWriter();
			for (Cookie cookie : cookies) {
				builder.setLength(0);
				// 结果类似于var token='test123';
				builder.append("var ")
					   .append(cookie.getName())
					   .append("=")
					   .append("'")
					   .append(cookie.getValue())
					   .append("'")
					   .append(";");
				writer.write(builder.toString());
			}
		}
	}

}
