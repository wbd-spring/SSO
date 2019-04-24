package com.wbd.sso.server.model;

import java.io.Serializable;

/**
 * 抽象用户类，用户可能通过用户名，或者手机号，或者二维码登录，所以进行抽象
 * @author jwh
 *
 */
public abstract class LoginUser  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
