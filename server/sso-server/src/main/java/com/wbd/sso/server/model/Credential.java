package com.wbd.sso.server.model;

/**
 * 用户可能通过用户名，或者手机号，或者二维码登录，所以进行抽象
 * 不同的登录方式，导致用户属性凭证不一样
 * 
 * 登录凭证(抽象类，可能是手机号码+验证码， 可能是用户名+密码，可能是二维码)
 * 对登录页面提交的内容集中存储， 并提供特定获取方法的一个实体类
 * 
 * @author jwh
 *
 */
public abstract class Credential {

	// 错误信息
	private String error;

	// 获取一个参数值
	public abstract String getParameter(String name);

	// 获取多个参数值
	public abstract String[] getParameterValue(String name);

	/**
	 * 由PreLoginHandler通过setSessionValue()方法写入特定session属性值
	 * 
	 * @return
	 */
	public abstract Object getSettedSessionValue();

	/**
	 * 授权失败时，设置失败提示信息
	 * 
	 * @param errorMsg
	 */
	public void setError(String errorMsg) {
		this.error = errorMsg;
	}

	/**
	 * 获取失败提示信息
	 * 
	 * @return
	 */
	public String getError() {
		return this.error;
	}
}
