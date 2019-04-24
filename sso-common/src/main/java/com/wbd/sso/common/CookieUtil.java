package com.wbd.sso.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 操作cookie
 * 
 * @author Administrator
 *
 */
public class CookieUtil {

	private CookieUtil() {
	}

	/**
	 * 查找特定cookie�?
	 * 
	 * @param cookieName
	 * @param request
	 * @return
	 */
	public static String getCookie(String cookieName, HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return cookie.getValue();
				}
			}
		}

		return null;
	}
}
