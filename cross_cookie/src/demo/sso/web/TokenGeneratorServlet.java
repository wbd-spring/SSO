package demo.sso.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 此servlet用来生成token
 */
@WebServlet("/tg")
public class TokenGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 请求的原始来源域
		String from  = request.getParameter("from");
		
		// 生成token
		String token = "test111";
		
		response.sendRedirect(from + "?cname=token&cval=" + token );
	}

}
