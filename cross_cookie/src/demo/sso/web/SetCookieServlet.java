package demo.sso.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将此servlet部署到等待cookie被写入的域中<br>
 * 例如：希望在test.loc域的页面中将cookie写入other.loc域中，则应将此servlet部署到other.loc域下
 */
@WebServlet("/set_cookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 其它域通过页面script标签引用此servlet，script标签发起的请求是get类型，将实现写入doGet方法中
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// P3P
		// response.addHeader("P3P", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");
		
		// 将要写入的cookie项，调用者通过参数传递
		String cookieName = request.getParameter("cname");
		String cookieVal = request.getParameter("cval");

		// 生成cookie 
		Cookie cookie = new Cookie(cookieName, cookieVal);
		cookie.setPath("/"); //www.a.com
		// 一般可以将domain设置到顶级域
		// cookie.setDomain("sub.a.com"); 
		response.addCookie(cookie);
	}

}
