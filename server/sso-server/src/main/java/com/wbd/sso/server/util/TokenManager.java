package com.wbd.sso.server.util;

import java.util.HashMap;
import java.util.Map;

import com.wbd.sso.server.model.LoginUser;

/**
 * 存储user信息，并提供操作方法
 * 
 * @author jwh
 *
 */
public class TokenManager {

	public static final Map<String, LoginUser> DATA_MAP = new HashMap<String, LoginUser>();

	private TokenManager() {}
	public  static LoginUser validate(String vt) {
		//TODO is 
		return DATA_MAP.get(vt);
	}
}
